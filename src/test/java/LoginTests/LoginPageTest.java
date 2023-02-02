package LoginTests;

import PageHelpers.HomePage;
import PageHelpers.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class LoginPageTest extends TestBase{

    LoginPage loginPage;
    HomePage homePage;
    String rancherPageTitle ="Rancher";
    Logger log = Logger.getLogger(LoginPageTest.class);

    public LoginPageTest(){
        super();
    }

    @BeforeClass
    public void setup(){
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
        homePage = loginPage.loginUser(baseCommon.getConfig("rancherusername"),baseCommon.getConfig("rancherpassword"));
        Assert.assertTrue(homePage.validateHomePageLogo());
    }
}
