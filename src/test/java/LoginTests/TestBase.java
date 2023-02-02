package LoginTests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
    static Logger log = Logger.getLogger(TestBase.class);

    @BeforeTest(alwaysRun = true)
    public void handleTestMethodName(Test test) {
        String testName = test.testName();
        log.info("currently running test: " + this.getClass().getSimpleName() + ":" + testName);
    }

}
