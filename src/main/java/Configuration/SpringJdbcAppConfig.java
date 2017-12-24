package Configuration;

//import org.apache.commons.dbcp.BasicDataSource;
import beans.SpringJDBCUtils.SpringDAOImpl;
import beans.SpringJDBCUtils.SpringjdbcDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringJdbcAppConfig {

    @Bean
    public SpringjdbcDAO springjdbcDAO(){

        return new SpringDAOImpl(dataSource());

    }
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://localhost:3306/world");
        dataSource.setPassword("qaz123");
        dataSource.setUsername("root");
        dataSource.setInitialSize(1);
        dataSource.setMaxTotal(5);

        return dataSource;
    }


}
