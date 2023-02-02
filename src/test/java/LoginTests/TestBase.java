package LoginTests;

import base.BaseCommon;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

public class TestBase {
    static Logger log = Logger.getLogger(TestBase.class);
    BaseCommon baseCommon = new BaseCommon();

    @BeforeClass
    public void initialiseDriver(){
        baseCommon.initialization();
    }
   // @BeforeTest(alwaysRun = true)
    public void handleTestMethodName(Method method) {
        String testName = method.getName();
        log.info("currently running test: " + this.getClass().getSimpleName() + ":" + testName);
    }
    @AfterClass
    public void tearDown(){
        baseCommon.driver.quit();
    }

}
