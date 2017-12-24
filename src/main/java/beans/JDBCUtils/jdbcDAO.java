package beans.JDBCUtils;

import beans.City;
//import org.springframework.data.repository.CrudRepository;

public interface jdbcDAO {

    void insert(City city);
    void update(City city);
    void delete(City city);
    City findCityById(int id);




}
