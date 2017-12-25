package beans.PlainJdbc;

import beans.Country;

import java.util.List;

public interface CountryRepository {

    void insertCountry(Country country);
    void deleteCountry(Country country);
    void updateCountry(Country country);
    Country getCountryById(int id);
    List<Country> getAllCountries();




}
