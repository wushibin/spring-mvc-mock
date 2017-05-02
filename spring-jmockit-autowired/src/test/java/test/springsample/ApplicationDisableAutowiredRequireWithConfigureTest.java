package test.springsample;

import org.junit.Test;
import org.junit.runner.RunWith;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(initializers = ApplicationDisableAutowiredRequireWithConfigureTest.DisableAutowireRequireInitializer.class)
public class ApplicationDisableAutowiredRequireWithConfigureTest {

    @Configuration
    static class Config {
        @Bean
        JmockitApplication jmockitApplication(){
            return new JmockitApplication();
        }

        @Bean
        ServiceOne serviceOne(){
            return new ServiceOneImp();
        }
    }

    static class DisableAutowireRequireInitializer implements ApplicationContextInitializer<GenericApplicationContext> {

        public void initialize(GenericApplicationContext applicationContext) {
            BeanDefinition beanDefinition =
                    BeanDefinitionBuilder.rootBeanDefinition(AutowiredAnnotationBeanPostProcessor.class)
                    .addPropertyValue("requiredParameterValue", false)
                    .getBeanDefinition();

            applicationContext.registerBeanDefinition(AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME,
                    beanDefinition);

            new AnnotatedBeanDefinitionReader(applicationContext).register(Config.class);
        }
    }

    @Autowired
    JmockitApplication application;

    @Test(expected = NullPointerException.class)
    public void echoMessageTest()
    {
        application.echoMessage();
    }

}
