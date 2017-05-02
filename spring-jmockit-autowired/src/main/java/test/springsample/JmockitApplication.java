package test.springsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class JmockitApplication
{
    final Logger logger = LoggerFactory.getLogger(JmockitApplication.class);

    @Autowired
    private ServiceOne serviceOne;

    @Autowired
    private ServiceTwo serviceTwo;

    public void echoMessage(){
        logger.info(serviceOne.getServiceOneName());
        logger.info(serviceTwo.getServiceTwoName());
    }
}
