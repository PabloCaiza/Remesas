package user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@ApplicationScoped
public class UserRepository {

     @Inject
     private EntityManager entityManager;


    public void saveUser(User user){
        maniputaleDB(em -> em.persist(user));
    }
    public void removeUser(User user){
       maniputaleDB(em->em.remove(user));
    }
    public  User findUserById(int id){
        return entityManager.createNamedQuery("findUserById",User.class)
                .setParameter("id",id)
                .getSingleResult();

    }

    public Optional<User> findUserByUsername(String username){
        return Optional.of(entityManager.createNamedQuery("findUserByUsername",User.class)
        .setParameter("username",username)
        .getSingleResult());

    }

    public List<User> findAllUsers(){
        return entityManager.createNamedQuery("findAllUser",User.class).getResultList();
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
