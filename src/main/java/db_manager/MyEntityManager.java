package db_manager;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ApplicationScoped
public class MyEntityManager {

    @Produces
    @ApplicationScoped
    private EntityManager entityManager(){
        return Persistence.createEntityManagerFactory("my_unit").createEntityManager();
    }


}
