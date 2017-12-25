/*package Main;

import Configuration.*;
import beans.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class JdbcMain {


    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcAppConfig.class);
        jdbcDAO jdbcdao=(jdbcDAO)context.getBean(jdbcDAO.class);

        City city1=new City(8009,"Kharkiv","17845","Kharkovskaya",487598);
        City city2=new City(8009,"Kiev","614859","Kievskaya",3252654);

       System.out.println("------Inserting Kharkiv into database-------");
        jdbcdao.insert(city1);

        System.out.println("------Looking for inserted row by id-------");
        City city=jdbcdao.findCityById(8009);

        System.out.println(city.toString());

        jdbcdao.update(city2);
        System.out.println("------Deleting city with id 7899-------");

        jdbcdao.delete(city1);
        System.out.println("------Check if city is deleted-------");

    City newCity= jdbcdao.findCityById(8009);
        System.out.println(newCity.toString());
        }
    }*/


