package Configuration;
import beans.PlainJdbcUtils.*;
//import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcAppConfig {

@Bean
    public jdbcDAO jdbcdao(){

    return new jdbcDaoImpl(dataSource());

    }

    @Bean
    public DataSource dataSource(){

        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://localhost:3306/world");
        dataSource.setUsername("root");
        dataSource.setPassword("qaz123");
        dataSource.setInitialSize(2);
        dataSource.setMaxTotal(5);



        return dataSource;
    }




}
