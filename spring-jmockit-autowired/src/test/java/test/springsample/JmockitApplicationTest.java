package test.springsample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JmockitApplicationTest
{
    @Autowired
    JmockitApplication application;

    @Test
    public void echoMessage()
    {
        application.echoMessage();
    }

}