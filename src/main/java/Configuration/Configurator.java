package Configuration;

import beans.City;
import beans.HibernateUtils.HibernateDAO;
import beans.HibernateUtils.HibernateDAOImpl;
import com.mysql.jdbc.Driver;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;


@Configuration
public class Configurator {

    @Bean
    public HibernateDAO hibernateDAO(){
        return new HibernateDAOImpl(sessionFactoryBean().getObject());
    }




@Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        localSessionFactoryBean.setPackagesToScan(getClass().getPackage().getName());
        return  localSessionFactoryBean;


    }

@Bean
    public DataSource dataSource(){

      SimpleDriverDataSource dataSource=new SimpleDriverDataSource();
      dataSource.setUrl("jdbc:mysql://localhost:3306/world");
      dataSource.setPassword("qaz123");
      dataSource.setUsername("root");
      dataSource.setDriverClass(Driver.class);
      return dataSource;

    }

    public Properties hibernateProperties(){

        Properties properties=new Properties();

        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/world");

       return  properties;
    }



}
