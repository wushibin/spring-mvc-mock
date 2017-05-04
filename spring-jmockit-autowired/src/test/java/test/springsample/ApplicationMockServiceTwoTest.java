package test.springsample;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.springsample.imp.ServiceOneImp;
import test.springsample.imp.ServiceTwoImp;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationMockServiceTwoTest.ApplicationConfig.class)
public class ApplicationMockServiceTwoTest
{
    final Logger logger = LoggerFactory.getLogger(ApplicationMockServiceTwoTest.class);

    @Configuration
    static class ApplicationConfig
    {
        @Bean
        ServiceOne serviceOne()
        {
            return new ServiceOneImp();
        }

        @Bean
        ServiceTwo serviceTwo()
        {
            return new ServiceTwoImp();
        }

        @Bean
        JmockitApplication jmockitApplication()
        {
            return new JmockitApplication();
        }
    }

    @Autowired
    JmockitApplication application;

    @Mocked
    ServiceTwo serviceTwo;

    @Test
    public void echoMessage()
    {
        new Expectations() {{
            serviceTwo.getServiceTwoName(); result = "Mock the service two";
        }};

        Deencapsulation.setField(application, serviceTwo);

        application.echoMessage();
    }

}
