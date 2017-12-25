package Main;
import Configuration.Configurator;
import beans.*;
import Database.HibernateRepository.HibernateDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateMain {

    public  static  void main(String[]args){

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Configurator.class);
        HibernateDAO hibernateDAO=(HibernateDAO)applicationContext.getBean(HibernateDAO.class);

        City cities=hibernateDAO.findCityById(666);


        System.out.println(cities.toString());


    }

}
