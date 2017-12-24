package beans.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



    /**
     * Configuration class to setup Spring MVC.
     *
     * @author Marten Deinum
     *
     */
    @Configuration
    @EnableWebMvc
    @ComponentScan("beans.Controller")
    public class WebAppConfig {

        @Bean
        public ViewResolver internalResourceViewResolver() {
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("/WEB-INF/");
            viewResolver.setSuffix(".jsp");
            return viewResolver;
        }
    }

