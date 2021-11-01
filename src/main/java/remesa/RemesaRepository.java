package remesa;

import user.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Consumer;

@ApplicationScoped
public class RemesaRepository {
    @Inject
    EntityManager entityManager;

    public void saveRemesa(Remesa remesa){
        maniputaleDB(em -> em.persist(remesa));
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
    public List<Remesa> findRemesaByState(boolean state){
        return  entityManager.createNamedQuery("findRemesaByState",Remesa.class)
                .setParameter("state",state)
                .getResultList();
    }
    public List<Remesa> findRemesaByUser(User user){
        return entityManager.createNamedQuery("findRemesaByUser",Remesa.class)
                .setParameter("sender",user)
                .getResultList();
    }

}
