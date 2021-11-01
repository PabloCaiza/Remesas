package remesa;

import agent.AgentRepository;
import session.SessionController;
import user.User;
import user.UserService;
import user.UserType;
import util.CommonUtils;
import vehicle.Vehicle;
import vehicle.VehicleService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class RemesaController implements Serializable {
    @Inject
    private RemesaService remesaService;
    @Inject
    private VehicleService vehicleService;
    @Inject
    private UserService userService;
    @Inject
    private AgentRepository agentRepository;
    @Inject
    private SessionController session;
    private Remesa newRemesa;
    private RemesaType[] remesaTypes;
    private List<User> users;
    private List<Vehicle> vehicles;
    private int numAgents;
    private int maxAgents;
    private List<Integer> agentIds;
    private int receiverId;
    private int vehicleId;

    @PostConstruct
    public void init() {
        newRemesa = new Remesa();
        users = userService.getUsers()
                .stream()
                .filter(user -> user.getUserType().name().equals(UserType.CLIENTE.name()))
                .collect(Collectors.toList());
        vehicles = vehicleService.getVehicles();
        remesaTypes = RemesaType.values();
        agentIds = agentRepository.findIdsOfAgents();
        maxAgents = agentIds.size();
    }

    public void createRemesa() {
        newRemesa.setVehicle(vehicleService.getVehicleById(vehicleId));
        newRemesa.setReceiver(userService.getUserById(receiverId));
        newRemesa.setSender(session.getUser());
        newRemesa.setAgents(remesaService.assignAggent(numAgents));
        remesaService.createRemesa(newRemesa);
        newRemesa = new Remesa();
        numAgents = 1;
        CommonUtils.addMessage(FacesMessage.SEVERITY_INFO,"Succesful","La solicitud se envio correctamente");
    }

    public Remesa getNewRemesa() {
        return newRemesa;
    }

    public void setNewRemesa(Remesa newRemesa) {
        this.newRemesa = newRemesa;
    }

    public RemesaType[] getRemesaTypes() {
        return remesaTypes;
    }

    public void setRemesaTypes(RemesaType[] remesaTypes) {
        this.remesaTypes = remesaTypes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getNumAgents() {
        return numAgents;
    }

    public void setNumAgents(int numAgents) {
        this.numAgents = numAgents;
    }

    public int getMaxAgents() {
        return maxAgents;
    }

    public void setMaxAgents(int maxAgents) {
        this.maxAgents = maxAgents;
    }


    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
