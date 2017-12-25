package Controller;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {FunctionalService.class};
    }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class<?>[] {WebAppConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] {"/", "/hello"};
        }
    }

