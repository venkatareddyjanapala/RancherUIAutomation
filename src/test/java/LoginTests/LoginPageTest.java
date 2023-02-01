package LoginTests;

import base.BaseCommon;
import PageHelpers.HomePage;
import PageHelpers.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginPageTest extends BaseCommon{

    LoginPage loginPage;
    HomePage homePage;
    String rancherPageTitle ="Rancher";
    Logger log = Logger.getLogger(LoginPageTest.class);

    public LoginPageTest(){
        super();
    }

    @BeforeClass
    public void setup(){
        initialization();
        loginPage = new LoginPage();
        log.info("entering dkjhdsf ++++ ++++++++++++++++++");
    }

    @Test
    public void RancherPageTest() throws InterruptedException {
        log.info("entering dkjhdsf ++++ ++++++++++++++++++");

        Assert.assertEquals(loginPage.validateLoginPageTitle(),rancherPageTitle);
       // Thread.sleep(2000);
      //  Assert.assertTrue(loginPage.checkRancherLogo());
    }

    @Test
    public void loginUserTest() throws InterruptedException {
        log.info("entering dkjhdsf ++++ ++++++++++++++++++");

        homePage = loginPage.loginUser(properties.getProperty("rancherusername"),properties.getProperty("rancherpassword"));
        Assert.assertTrue(homePage.validateHomePageLogo());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
