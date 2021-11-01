package vehicle;

import user.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

import java.util.function.Consumer;

@ApplicationScoped
public class VehicleRepository {
    @Inject
    private EntityManager entityManager;


    public void saveVehicle(Vehicle vehicle){
        maniputaleDB(em -> em.persist(vehicle));
    }
    public void removeVehicle(Vehicle vehicle){ maniputaleDB(em->em.remove(vehicle));}
    public List<Vehicle> findAllVehicle(){
        return entityManager.createNamedQuery("findAllVecicle",Vehicle.class).getResultList();
    }
    public Vehicle findVehicleById(int id){
        return entityManager.createNamedQuery("findVecicleById",Vehicle.class)
                .setParameter("id",id)
                .getSingleResult();
    }
    public void maniputaleDB(Consumer<EntityManager> consumer){
        entityManager.getTransaction().begin();
        try{
            consumer.accept(entityManager);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }

    }
}
