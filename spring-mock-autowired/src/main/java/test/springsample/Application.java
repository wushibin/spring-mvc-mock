package test.springsample;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

public class Application {

    @Autowired
    @Getter
    private Message message;

    public void echoMessage() {
        System.out.println(message.getMessage());
    }

    public String getMessageString(){
        return message.toString();
    }

}
