package test.springsample;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ApplicationTest {

    final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    @Autowired
    Application application;

//    @Mock

    @org.junit.Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
    }

    @org.junit.Test
    public void echoMessage() throws Exception {
        when(application.getMessage().getMessage()).thenReturn("hello world");
        when(application.getMessage().toString()).thenReturn("hello world world");

        application.echoMessage();
        logger.info(application.getMessageString());
    }

}