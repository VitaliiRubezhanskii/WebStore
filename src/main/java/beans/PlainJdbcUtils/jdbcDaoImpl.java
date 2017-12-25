package beans.PlainJdbcUtils;

import beans.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


public class jdbcDaoImpl implements jdbcDAO {

    private final DataSource dataSource;
    public jdbcDaoImpl(DataSource dataSource){

        this.dataSource=dataSource;
    }

    @Override
    public void insert(City city) {

      String sql="INSERT INTO CITY (ID,Name,District,Population) VALUES(?,?,?,?)";
      Connection connection=null;
      try{
          connection=dataSource.getConnection();
          PreparedStatement preparedStatement=connection.prepareStatement(sql);
          preparedStatement.setInt(1,city.getId());
          preparedStatement.setString(2,city.getName());

          preparedStatement.setString(3,city.getDistrict());
          preparedStatement.setInt(4,city.getPopulation());
          preparedStatement.executeUpdate();
          preparedStatement.close();

      }
      catch(SQLException e){
          throw new RuntimeException(e);
      }
        finally {
          if (connection != null) {
              try{
              connection.close();

                    } catch (SQLException e){

              }

          }
      }

    }

    @Override
    public void update(City city) {
        String sql="UPDATE CITY SET Name=?,District=?,Population=? WHERE ID=?";
        Connection connection=null;
        try{
            connection=dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1,city.getName());

            preparedStatement.setString(2,city.getDistrict());
            preparedStatement.setInt(3,city.getPopulation());
            preparedStatement.setInt(4,city.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch(SQLException e){ throw new RuntimeException(e);}
        finally {
            if(connection!=null){
                try{
                    connection.close();
                }catch(SQLException e){}
            }

        }
    }

    @Override
    public void delete(City city) {
        String sql="DELETE FROM CITY WHERE ID=?";
        Connection connection=null;
        try{
            connection=dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,city.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException e) {throw new RuntimeException(e);
        }finally {
            if(connection!=null){
                try{
                    connection.close();
                }catch(SQLException e){

                }
            }


        }


    }

    @Override
    public City findCityById(int id) {
        String sql = "SELECT * FROM CITY WHERE ID=?";
        Connection connection = null;
        try {
            connection=dataSource.getConnection();
            City city = null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                city = new City(resultSet.getInt("ID"), resultSet.getString("Name"),resultSet.getString("CountryCode"),
                        resultSet.getString("District"), resultSet.getInt("Population"));

            }
            resultSet.close();
            preparedStatement.close();
            return city;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                }


            }
        }
    }

    public static void main(String[] args) {

        ;

        City city =new City(8000,"Zhytomyr","61000","Ukr",258789 );

    }
}
