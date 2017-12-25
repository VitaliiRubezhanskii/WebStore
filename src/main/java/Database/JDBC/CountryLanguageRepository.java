package Database.JDBC;

import beans.Country;
import beans.CountryLanguage;

import java.util.List;

public interface CountryLanguageRepository {
    void insertCountryLanguage(CountryLanguage countryLanguage);
    void deleteCountryLanguage(CountryLanguage countryLanguage);
    void updateCountryLAnguage(CountryLanguage countryLanguage);
    List<CountryLanguage> getAllCountryLanguages();
    CountryLanguage getCountryLanguageById(int id);
}
