package Controller;

import org.springframework.context.annotation.Bean;

public class FunctionalService {

    @Bean
    public Functional functional(){

        return new Functional();
    }
}
