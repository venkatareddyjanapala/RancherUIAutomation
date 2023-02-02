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
    private static final  String CHROME_DRIVER_PATH=BaseCommon.class.getClassLoader().getResource("chromedriver").getPath();
    private static final  String FIREFOX_DRIVER_PATH=BaseCommon.class.getClassLoader().getResource("geckodriver").getPath();

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
            System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            log.info("Browser Name: FireFox");
            System.setProperty("webdriver.firefox.driver",FIREFOX_DRIVER_PATH);
            driver = new FirefoxDriver();
        }
        driver.get(properties.getProperty("rancherurl"));
    }
    public String getConfig(String key){
        return properties.getProperty(key);
    }
}
