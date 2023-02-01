package PageHelpers;

import base.BaseCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.CommonWaits;

public class HomePage extends BaseCommon{

    CommonWaits commonWaits= new CommonWaits();
    @FindBy(xpath="//button[@class=\"navbar-brand logo btn\"]")
    WebElement homePageLogo;

    public  HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean validateHomePageLogo(){
     //  utilCommon.switchToFrameMainPanel();
        commonWaits.setExplicitWait()
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"navbar-brand logo btn\"]")));
        return homePageLogo.isDisplayed();
    }
}
