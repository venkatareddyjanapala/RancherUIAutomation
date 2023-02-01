package util;

import base.BaseCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CommonWaits extends BaseCommon {
    public static long EXPLICIT_WAIT = 60;
    public static long IMPLICIT_WAIT = 10;
    public static long POLLING_TIME = 5;


    public void switchToFrameMainPanel(){
        driver.switchTo().frame("mainpanel");
    }
    public WebDriverWait setExplicitWait(){
      WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
      return wait;
    }
    public WebDriverWait setExplicitWait(long timeUnit){
        WebDriverWait wait = new WebDriverWait(driver, timeUnit);
        return wait;
    }
    public void setImplicitWait() throws InterruptedException {
        Thread.sleep(IMPLICIT_WAIT);
    }
    public FluentWait getFluentWait(WebDriver driver){
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(EXPLICIT_WAIT, TimeUnit.SECONDS)
                .pollingEvery(POLLING_TIME, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        return wait;
    }

}
