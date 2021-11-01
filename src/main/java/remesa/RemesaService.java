package remesa;

import agent.Agent;
import agent.AgentRepository;
import agent.AgentService;
import user.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class RemesaService {
    @Inject
    RemesaRepository remesaRepository;
    @Inject
    AgentRepository agentRepository;

    public void createRemesa(Remesa remesa){
        remesaRepository.saveRemesa(remesa);
    }
    public void updateRemesa(Remesa remesa){
        remesaRepository.saveRemesa(remesa);
    }
    public List<Agent> assignAggent(int numOfAgents){
        List<Agent> assignedAgentes=new ArrayList<>();
        List<Integer> idsOfAgents = agentRepository.findIdsOfAgents();
        for(int i=0;i<numOfAgents;i++){
            int index= ThreadLocalRandom.current().nextInt(0,idsOfAgents.size());
            Agent agent=new Agent();
            agent.setId(idsOfAgents.get(index));
            assignedAgentes.add(agent);
            idsOfAgents.remove(index);
        }
        return assignedAgentes;
    }
    public List<Remesa> getRemesasByState(boolean state){
        return remesaRepository.findRemesaByState(state);

    }

    public List<Remesa> getRemesaByUser(User user){
     return  remesaRepository.findRemesaByUser(user);
    }
}
