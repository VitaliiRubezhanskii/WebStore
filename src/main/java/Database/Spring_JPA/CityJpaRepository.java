package Database.Spring_JPA;

import beans.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface CityJpaRepository extends CrudRepository<City,Integer> {

}

