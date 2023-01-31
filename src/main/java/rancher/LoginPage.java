package rancher;

import base.BaseCommon;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseCommon {


    @FindBy(xpath="/html/body/div[2]/div[4]/div[1]/div/section/div[2]/form/div[1]/div/input[@type = \"text\"]")
    WebElement username;
    @FindBy(xpath="/html/body/div[2]/div[4]/div[1]/div/section/div[2]/form/div[2]/div/input[@type =\"password\"]")
    WebElement password;
    //*[@id="ember1987"]/form/p/button
    @FindBy(xpath="/html/body/div[2]/div[4]/div[1]/div/section/div[2]/form/p/button")
    WebElement loginButton;

    @FindBy(xpath="//*[@id=\"application\"]/div[1]/div/h1/text()[1]")
    WebElement rancherLogo;

    //Initialize Page Factory/Object repositories

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

    public HomePage loginUser(String usern, String pwd){
        username.sendKeys(usern);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }



}
