package Database.Spring_JPA;

import beans.City;

import java.util.List;

public interface Repositori {

    public City getCityByID(int id);
    public void insertCity(City city);
    public void deleteCity(int id);
    public List<City> findAllCities();
}
