package Main;

import Configuration.SpringJdbcAppConfig;
import beans.City;

import beans.SpringJDBCUtils.SpringjdbcDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcMain {


        public static void main(String[] args) {

            ApplicationContext context=new AnnotationConfigApplicationContext(SpringJdbcAppConfig.class);
            SpringjdbcDAO springjdbcDAO=(SpringjdbcDAO) context.getBean(SpringjdbcDAO.class);

            //City city1=new City(7906,"Kharkiv","Kharkovskaya",487598);
            //City city2=new City(7906,"Kiev","Kievskaya",3252654);
            City city;
            System.out.println("------Inserting Kharkiv into database-------");
           // springjdbcDAO.insert(city1);

            System.out.println("------Looking for inserted row by id-------");


           /*springjdbcDAO.update(city2);
            System.out.println("------Deleting city with id 7901------");*/

      /*  jdbcdao.delete(city1);
        System.out.println("------Check if city is deleted-------");*/

         //   city= springjdbcDAO.findById(5);
          //  System.out.println(city.getName());
            List<String> l=new ArrayList<String>();
        }
    }

