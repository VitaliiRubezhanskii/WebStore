package beans.PlainJdbc;

import beans.City;

import java.util.List;

public interface CityRepository {

    void insertCity(City city);
    void deleteCity(City city);
    void updateCity(City city);
    List<City> getAllCities();
    City getCityById(int id);


}
