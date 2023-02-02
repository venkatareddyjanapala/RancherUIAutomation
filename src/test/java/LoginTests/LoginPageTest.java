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
        log.info("Running the class:" + this.getClass().getSimpleName());
    }

    @Test
    public void RancherPageTest() {
        log.info("Running the test:RancherPageTest");
        Assert.assertEquals(loginPage.validateLoginPageTitle(),rancherPageTitle);
    }

    @Test
    public void loginUserTest() throws InterruptedException {
        log.info("Running the test:loginUserTest");
        homePage = loginPage.loginUser(properties.getProperty("rancherusername"),properties.getProperty("rancherpassword"));
        Assert.assertTrue(homePage.validateHomePageLogo());
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
