
package beans.PlainJdbc;
import beans.AbstractWorld;
import beans.City;
import beans.Country;
import beans.CountryLanguage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainJdbcAccess {

    public static void init() throws ClassNotFoundException{
     Class.forName("com.mysql.jdbc.Driver");
    }
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","qaz123");

    }

    public void insert(AbstractWorld abstractWorld){

        Connection connection=null;
        Statement statement=null;
        String tableName=null;
        List<String> columnNames;


        if(abstractWorld instanceof City){
            String sql="insert into city (ID, Name, CountryCode,District, Population) values ("+((City) abstractWorld).getId()+","
                             +((City)abstractWorld).getName()+","+((City)abstractWorld).getCountryCode()+","+((City)abstractWorld).getDistrict()+","
                    +((City)abstractWorld).getPopulation()+")";
        }
        else if (abstractWorld instanceof Country){
            String sql="insert into country (Code, Name, Continent,Region, SurfaceArea,IndepYear,Population,LifeExpectancy," +
                           "GNP,GNPOld,LocalName,GovernmentForm,HeadOfState,Capital,Code2) values ("+
                    ((Country) abstractWorld).getCode()+","+((Country) abstractWorld).getName()+","+((Country) abstractWorld).getContinent()+","+
                    ((Country) abstractWorld).getRegion()+","+((Country) abstractWorld).getSurfaceArea()+","+((Country) abstractWorld).getIndepYear()+
                    ","+((Country) abstractWorld).getPopulation()+","+((Country) abstractWorld).getLifeExpectancy()+","+((Country) abstractWorld).getGNP()+
                    ","+((Country) abstractWorld).getGNPOld()+","+((Country) abstractWorld).getLocalName()+","+((Country) abstractWorld).getGovernmentForm()+
                    ","+((Country) abstractWorld).getHeadOfState()+","+((Country) abstractWorld).getCapital()+","+((Country) abstractWorld).getCode_two()+")";

        }
        else if (abstractWorld instanceof CountryLanguage){
            String sql="insert into countrylanguage (CountryCode, Language, isOfficial,Percentage) values ("+
                    ((CountryLanguage) abstractWorld).getCountryCode()+","+((CountryLanguage) abstractWorld).getLanguage()+","+
                    ((CountryLanguage) abstractWorld).getIsOfficial()+","+((CountryLanguage) abstractWorld).getPercentage()+")";

        }

        try {
            connection = connect();

        }catch (SQLException ex){
            throw new RuntimeException(ex) ;
        }

    }

    public List<AbstractWorld> getAbstractWorldUnits(){

        AbstractWorld abstractWorld=new City();
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        String sql="select * FROM city";

        List<AbstractWorld> abstractWorldList=new ArrayList<AbstractWorld>();
        try{
          connection= connect();
          statement=connection.createStatement();
          resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                City city=new City();
                city.setId(resultSet.getInt(1));
                city.setName(resultSet.getString(2));
                city.setCountryCode(resultSet.getString(3));
                city.setDistrict(resultSet.getString(4));
                city.setPopulation(resultSet.getInt(5));
                abstractWorldList.add(city);
            }

        } catch(SQLException ex){
          ex.printStackTrace();


        }
        for (AbstractWorld x:abstractWorldList) {
            System.out.println(x.toString());
        }

        return abstractWorldList;
    }
    /*public AbstractWorld getAbstractWorlUnitdById(int id){

    }*/

    PlainJdbcAccess plainJdbcAccess;

    public static void main(String[] args) {

        PlainJdbcAccess plainJdbcAccess;

        plainJdbcAccess.getAbstractWorldUnits();

    }


}
