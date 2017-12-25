package beans.PlainJdbcUtils;
import beans.City;
import beans.PlainJdbc.CityRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepositoryImpl implements CityRepository {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public static void init() throws ClassNotFoundException{
           Class.forName("com.mysql.jdbc.Driver");
    }
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","qaz123");

    }

    @Override
    public void insertCity(City city) {
        try{
        connection=connect();
        String sql="insert into city (ID,Name,CountryCode,District,Population) values(?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,city.getId());
            preparedStatement.setString(2,city.getName());
            preparedStatement.setString(3,city.getCountryCode());
            preparedStatement.setString(4,city.getDistrict());
            preparedStatement.setInt(5,city.getPopulation());
            preparedStatement.executeUpdate();
            preparedStatement.close();
    } catch (SQLException ex){
        throw new RuntimeException("SQL Exception was thrown");
        }
        finally {
        if(connection!=null)
            try{
                connection.close();
            } catch (SQLException ex){
                throw new RuntimeException("SQL Exception was thrown");
            }
        }
    }

    @Override
    public void deleteCity(City city) {
        try{
            connection=connect();
            String sql="DELETE FROM CITY WHERE ID=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,city.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex){
            throw new RuntimeException("SQL Exception was thrown");

        }finally {
            if(connection!=null)
                try{
                    connection.close();
                }catch (SQLException ex){
                    throw new RuntimeException("SQL Exception was thrown");
                }
        }

    }

    @Override
    public void updateCity(City city) {



        String sql2="UPDATE CITY SET Name=?,District=?,Population=? WHERE ID=?";
            try{
                Connection connection=connect();
                String sql="UPDATE city SET Name=?,CountryCode=?,District=?,Population=?  WHERE ID=?";
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                 preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,city.getName());
                preparedStatement.setString(2,city.getCountryCode());
                preparedStatement.setString(3,city.getDistrict());
                preparedStatement.setInt(4,city.getPopulation());
                preparedStatement.setInt(5,city.getId());

                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException ex){
                throw new RuntimeException("SQL Exception 1 was thrown");

            }finally {
                if(connection!=null)
                    try{
                        connection.close();
                    }catch (SQLException ex){
                        throw new RuntimeException("SQL Exception 2 was thrown");
                    }
            }
    }

    @Override
    public List<City> getAllCities() {

        List<City> list=new ArrayList<City>();
        String sql = "SELECT * FROM city";
            try {
                connection = connect();


                statement = connection.createStatement();
                  resultSet = statement.executeQuery(sql);


                while (resultSet.next()){
                    City city=new City();
                 city=new City(resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getString("CountryCode"),
                         resultSet.getString("District"), resultSet.getInt("Population"));
                    list.add(city);
                }

            } catch (SQLException ex) {
                throw new RuntimeException("SQL Exception was thrown");

            } finally {
                if (connection != null)
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException("SQL Exception was thrown");
                    }
            }
                list.forEach((City city)->System.out.println("Test row: "+city.getId()+"; "+city.getName()+"; "+city.getCountryCode()+"; "+
                                city.getDistrict()+"; "+city.getPopulation()));
            return list;
        }

        @Override
        public City getCityById(int id){
            City city=null;

            try {
                connection = connect();
                String sql = "SELECT * FROM CITY WHERE ID=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next())

                    city = new City(resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getString("CountryCode"),
                            resultSet.getString("District"), resultSet.getInt("Population"));


            } catch (SQLException ex) {
                throw new RuntimeException("SQL Exception was thrown");

            } finally {
                if (connection != null)
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException("SQL Exception was thrown");
                    }
            }
            //System.out.println("Test row: "+city.toString());
            System.out.println("Test row: "+city.getId()+"; "+city.getName()+"; "+city.getCountryCode()+"; "+city.getDistrict()+"; "+city.getPopulation());



        return city;
    }

    private static void TestCityRepository() {
        CityRepositoryImpl cityRepository=new CityRepositoryImpl();
        City city =new City(8000,"Burluk","79","Ukr",2500 );
        City city2 =new City(8000,"Volnovakha","100","Ukr",3258 );

        cityRepository.insertCity(city2);
        cityRepository.getCityById(8000);
        cityRepository.updateCity(city);
        cityRepository.getCityById(8000);
        cityRepository.deleteCity(city);
        cityRepository.getAllCities();
    }

    public static void main(String[] args) {

        TestCityRepository();
    }

}

