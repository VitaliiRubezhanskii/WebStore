package Database.Spring_JDBC;
import beans.City;
import org.springframework.jdbc.core.*;
import java.sql.*;
import java.util.List;
import javax.sql.DataSource;

public class SpringDAOImpl implements SpringjdbcDAO {

    private final DataSource dataSource;

    public SpringDAOImpl(DataSource dataSource){

        this.dataSource=dataSource;
    }

    @Override
    public void insert(City city) {
        String sql="INSERT INTO CITY (ID,Name,District,Population) VALUES (?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
        jdbcTemplate.update(sql,city.getId(),city.getName(),city.getDistrict(),city.getPopulation());
    }

    @Override
    public void update(City city) {
    String sql="UPDATE CITY SET Name=?,District=?,Population=? WHERE ID=?";
    JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
    jdbcTemplate.update(sql,city.getName(),city.getDistrict(),city.getPopulation(),city.getId());

    }

    @Override
    public void delete(City city) {
        String sql="DELETE FROM CITY WHERE ID=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
        jdbcTemplate.update(sql,city.getId());

    }

    @Override
    public void insertBatch(final List<City> cities) {
        String sql="INSERT INTO CITY (ID,Name,District,CountryCode,Population) VALUES (?,?,?,?)";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(this.dataSource);
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                City city=cities.get(i);
                preparedStatement.setInt(1,city.getId());
                preparedStatement.setString(2,city.getName());
                preparedStatement.setString(3,city.getDistrict());
                preparedStatement.setString(4,city.getCountryCode());
                preparedStatement.setInt(5,city.getPopulation());


            }

            @Override
            public int getBatchSize() {
                return cities.size();
            }
        });
    }

    @Override
    public List<City> findById(int id) {
        String sql = "SELECT * FROM CITY WHERE ID=?";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        return jdbcTemplate.queryForList(sql,City.class,id);



    }
}
