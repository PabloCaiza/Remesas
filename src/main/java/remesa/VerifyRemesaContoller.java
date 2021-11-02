package remesa;

import agent.AgentService;
import session.SessionController;
import user.UserService;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class VerifyRemesaContoller implements Serializable {
    @Inject
    private SessionController session;
    private Remesa selectedRemesa;
    private List<Remesa> remesas;
    @Inject
    private RemesaService remesaService;
    @Inject
    private AgentService agentService;


    @PostConstruct
    public void init(){
        remesas=remesaService.getRemesaByUser(session.getUser())
                .stream()
                .filter(remesa -> remesa.getState())
                .collect(Collectors.toList());
        selectedRemesa=new Remesa();
        System.out.println(remesas.size());
    }

    public void selectRemesa(Remesa remesa){
        selectedRemesa=remesa;
        selectedRemesa.setAgents(selectedRemesa.getAgents().stream().map(agent ->
                agentService.getAgentbyId(agent.getId()))
                    .collect(Collectors.toList()));
    }

    public Remesa getSelectedRemesa() {
        return selectedRemesa;
    }

    public void setSelectedRemesa(Remesa selectedRemesa) {
        this.selectedRemesa = selectedRemesa;
    }

    public List<Remesa> getRemesas() {
        return remesas;
    }

    public void setRemesas(List<Remesa> remesas) {
        this.remesas = remesas;
    }
}
