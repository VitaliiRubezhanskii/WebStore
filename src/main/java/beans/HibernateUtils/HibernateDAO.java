package beans.HibernateUtils;
import beans.*;
import java.util.List;

public interface HibernateDAO {

    void store(City city);
    void delete(City city);
    List<City> findAll();
    City findCityById(int id);








}
