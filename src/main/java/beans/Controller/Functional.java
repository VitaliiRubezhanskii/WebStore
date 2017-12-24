package beans.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Functional {
@Bean
    public String sendMessage(String message){

        return message;
    }
}
