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
            FileInputStream ip = new FileInputStream("/Users/venkatareddy/IdeaProjects/RancherUIAutomation/src/main/java/config/config.properties");
            properties.load(ip);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            log.info("entered in chrome");
            System.setProperty("webdriver.chrome.driver","/Users/venkatareddy/IdeaProjects/" +
                    "/RancherUIAutomation/src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver","/Users/venkatareddy/IdeaProjects/" +
                    "/RancherUIAutomation/src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(UtilCommon.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(UtilCommon.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("rancherurl"));
    }
}
