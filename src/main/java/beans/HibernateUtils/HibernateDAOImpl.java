package beans.HibernateUtils;
import beans.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateDAOImpl implements HibernateDAO {

    private final SessionFactory sessionFactory;

    public HibernateDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
            }

    @Override
    public void store(City city) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();

        try{
            transaction.begin();
            session.saveOrUpdate(city);
            transaction.commit();
        }
        catch (RuntimeException e){

            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    @Override
    public void delete(City city) {

        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        try{
            transaction.begin();
            session.delete(city);
            transaction.commit();
        }
        catch(RuntimeException e){
            transaction.rollback();
            throw e;
        }
            finally{
            session.close();

        }
    }

    @Override
    public List<City> findAll() {
        Session session=sessionFactory.openSession();
        try{
            Query query=session.createQuery("from City");
            return query.list();
        }
        finally {
            session.close();
        }


    }

    @Override
    public City findCityById(int id) {
        Session session=sessionFactory.openSession();
        try{
            return (City)session.get(City.class,id);
        }
        finally {
            session.close();
        }


    }
}
