package beans.SpringJDBCUtils;
import beans.City;
import java.util.List;
public interface SpringjdbcDAO {

    void insert(City city);
    void update(City city);
    void delete(City city);
    void insertBatch(final List<City> cities);
    List<City> findById(int id);



}
