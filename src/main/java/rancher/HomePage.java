package rancher;

import base.BaseCommon;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.UtilCommon;

public class HomePage extends BaseCommon{

    UtilCommon utilCommon= new UtilCommon();

    @FindBy(xpath="//*[@id=\"application\"]/main/section[1]/h1")
    WebElement homePageName;

    @FindBy(xpath="//*[@id=\"ember768\"]/nav/div/div[1]/ul/li[1]/button")
    WebElement homePageLogo;

    public  HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean validateHomePageLogo(){
        utilCommon.switchToFrameMainPanel();
        return homePageLogo.isDisplayed();
    }
}
