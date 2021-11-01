package vehicle;


import session.SessionController;
import user.User;
import user.UserService;
import user.UserType;
import util.CommonUtils;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class VehicleController implements Serializable {
    @Inject
    private VehicleService vehicleService;
    @Inject
    private SessionController sessionController;
    private Vehicle newVehicle;
    private List<Vehicle> vehicles;
    private VehicleType[] typeOfVehicles;
    private Vehicle selectedVehicle;

    @PostConstruct
    public void init(){
        newVehicle=new Vehicle();
        vehicles=vehicleService.getVehicles();
        typeOfVehicles= VehicleType.values();
        selectedVehicle=new Vehicle();
    }


    public void createVehicle(){
        vehicleService.createVehicle(selectedVehicle);
        vehicles=vehicleService.getVehicles();
    }
    public void deleteVehicle(Vehicle vehicle){
        vehicleService.deleteVehicle(vehicle);
        vehicles=vehicleService.getVehicles();
    }

    public void selectVehicle(Vehicle vehicle){
        selectedVehicle=vehicle;
    }
    public void selectVehicle( ){
        selectedVehicle=new Vehicle();
    }

    public Vehicle getNewVehicle() {
        return newVehicle;
    }

    public void setNewVehicle(Vehicle newVehicle) {
        this.newVehicle = newVehicle;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleType[] getTypeOfVehicles() {
        return typeOfVehicles;
    }

    public void setTypeOfVehicles(VehicleType[] typeOfVehicles) {
        this.typeOfVehicles = typeOfVehicles;
    }

    public Vehicle getSelectedVehicle() {
        return selectedVehicle;
    }

    public void setSelectedVehicle(Vehicle selectedVehicle) {
        this.selectedVehicle = selectedVehicle;
    }
}
