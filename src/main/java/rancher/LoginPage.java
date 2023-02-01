package rancher;

import base.BaseCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import util.CommonWaits;

public class LoginPage extends BaseCommon {

    @FindBy(xpath="//input[@class = \"form-control login-user ember-view ember-text-field\"]")
    WebElement username;
    @FindBy(xpath="//input[@class = \"form-control login-pass ember-view ember-text-field\"]")
    WebElement password;
    //*[@id="ember1987"]/form/p/button
    @FindBy(xpath="//button[@class=\"btn btn-primary\"]")
    WebElement loginButton;

    @FindBy(xpath="//*[@id=\"application\"]/div[1]/div/h1/text()[1]")
    WebElement rancherLogo;

    //Initialize Page Factory/Object repositories
    CommonWaits commonWaits= new CommonWaits();

    public  LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Action classes

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean checkRancherLogo(){
        return rancherLogo.isDisplayed();
    }

    public HomePage loginUser(String usern, String pwd) throws InterruptedException {
        commonWaits.setExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//input[@class = \"form-control login-user ember-view ember-text-field\"]")));
        username.sendKeys(usern);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }



}
