package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseCommon {

    public static WebDriver driver;
    public static Properties properties;
    static Logger log = Logger.getLogger(BaseCommon.class);

    public BaseCommon(){
        try{
            properties = new Properties();
          FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
            properties.load(fis);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void initialization()  {
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            log.info("Browser Name: Chrome");
            // ClassLoader.loadClass("chromedriver");
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            log.info("Browser Name: FireFox");
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get(properties.getProperty("rancherurl"));
    }
    public String getConfig(String key){
        return properties.getProperty(key);
    }
}
