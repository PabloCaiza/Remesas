package agent;

import user.User;
import user.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AgentService {

    @Inject
    private AgentRepository agentRepository;

    public void createAgent(Agent agent) {
        agentRepository.saveAgent(agent);
    }

    public void modifyAgent(Agent agent) {
        agentRepository.saveAgent(agent);
    }

    public void deleteAgent(Agent agent) {
        agentRepository.removeAgent(agent);
    }

    public List<Agent> getAgents() {
        return agentRepository.findAllAgents();
    }

    public Agent getAgentbyId(int id){
        return agentRepository.findAgentById(id);
    }
    public List<Agent> filterAgentes(String filter){
        return agentRepository.findAgentByFilter(filter);
    }



}
