package test.springsample;

/**
 * Refer to the： http://stackoverflow.com/questions/3279868/how-to-turn-spring-autowired-required-property-to-false-for-test
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ApplicationDisableAutowiredRequireTest {
    @Autowired
    JmockitApplication application;

    @Test(expected = NullPointerException.class)
    public void echoMessageTest()
    {
        application.echoMessage();
    }
}
