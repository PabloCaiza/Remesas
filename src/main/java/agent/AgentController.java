package agent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.CommonsUploadedFile;
import org.primefaces.model.file.UploadedFile;
import session.SessionController;
import user.User;
import user.UserService;
import user.UserType;
import util.CommonUtils;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class AgentController implements Serializable {

    @Inject
    private AgentService agentService;
    private Agent newAgent;
    private List<Agent> agents;
    private AgentType[] agentTypes;
    private Agent selectedAgent;
    private UploadedFile originalImageFile;
    private String fileterText="";
    private  boolean enableChangeImage;

    @PostConstruct
    public void init(){
        newAgent=new Agent();
        agents=agentService.getAgents();
        agentTypes= AgentType.values();
        selectedAgent=new Agent();
    }
    public void filterAgents(){
        if(fileterText.isEmpty()){
            agents=agentService.getAgents();
            return;
        }
        agents=agentService.filterAgentes(fileterText);
    }
    public void createAgent(){
        if(originalImageFile==null){
            CommonUtils.addMessage(FacesMessage.SEVERITY_ERROR,"no image found","please uplad an image");
            return;
        }
        selectedAgent.setImage(originalImageFile.getContent());
        agentService.createAgent(selectedAgent);
        originalImageFile=null;
        agents=agentService.getAgents();
    }
    public void updateAgent(){
        selectedAgent.setImage(originalImageFile==null?selectedAgent.getImage():originalImageFile.getContent());
        agentService.createAgent(selectedAgent);
        originalImageFile=null;
        agents=agentService.getAgents();
    }
    public void deleteAgent(Agent agent){
        agentService.deleteAgent(agent);
        agents=agentService.getAgents();
    }

    public void handleFileUpload(FileUploadEvent event) {
        this.originalImageFile = null;
        UploadedFile file = event.getFile();
        if (file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.originalImageFile = file;
            CommonUtils.addMessage(FacesMessage.SEVERITY_INFO,"Succesful",this.originalImageFile.getFileName()+"is uploaded");

        }
    }
    public void  updateImage(){
        enableChangeImage=true;
    }
    public void selectAgent(Agent agent){
        enableChangeImage=false;
        selectedAgent=agent;
    }
    public void selectAgent( ){
        enableChangeImage=true;
        selectedAgent=new Agent();
    }


    public Agent getNewAgent() {
        return newAgent;
    }

    public void setNewAgent(Agent newAgent) {
        this.newAgent = newAgent;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public AgentType[] getAgentTypes() {
        return agentTypes;
    }

    public void setAgentTypes(AgentType[] agentTypes) {
        this.agentTypes = agentTypes;
    }

    public Agent getSelectedAgent() {
        return selectedAgent;
    }

    public void setSelectedAgent(Agent selectedAgent) {
        this.selectedAgent = selectedAgent;
    }

    public boolean isEnableChangeImage() {
        return enableChangeImage;
    }

    public void setEnableChangeImage(boolean enableChangeImage) {
        this.enableChangeImage = enableChangeImage;
    }

    public String getFileterText() {
        return fileterText;
    }

    public void setFileterText(String fileterText) {
        this.fileterText = fileterText;
    }
}
