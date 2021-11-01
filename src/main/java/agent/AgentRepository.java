package agent;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Consumer;

@ApplicationScoped
public class AgentRepository {
    @Inject
    private EntityManager entityManager;


    public void saveAgent(Agent agent) {
        maniputaleDB(em -> em.persist(agent));
    }

    public void removeAgent(Agent agent) {
        maniputaleDB(em -> em.remove(agent));
    }

    public List<Agent> findAllAgents() {
        return entityManager.createNamedQuery("findAllAgents", Agent.class).getResultList();
    }

    public Agent findAgentById(int id){
        return entityManager.find(Agent.class,id);
    }

    public List<Agent> findAgentByFilter(String filter){
        return entityManager.createNamedQuery("filterAgents",Agent.class)
                .setParameter("filter","%"+filter+"%")
                .getResultList();

    }
    public List<Integer> findIdsOfAgents(){
        return  entityManager.createNamedQuery("findIdsOfAgents",Integer.class)
                .getResultList();
    }
    public void maniputaleDB(Consumer<EntityManager> consumer) {
        entityManager.getTransaction().begin();
        try {
            consumer.accept(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

    }
}
