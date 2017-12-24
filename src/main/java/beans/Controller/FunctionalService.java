package beans.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class FunctionalService {

    @Bean
    public Functional functional(){

        return new Functional();
    }
}
