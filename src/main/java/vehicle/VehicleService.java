package vehicle;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class VehicleService {
    @Inject
    private VehicleRepository vehicleRepository;

    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.saveVehicle(vehicle);
    }

    public void modifyVehicle(Vehicle vehicle) {
        vehicleRepository.saveVehicle(vehicle);
    }
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.removeVehicle(vehicle);
    }
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAllVehicle();
    }
    public Vehicle getVehicleById(int id){return  vehicleRepository.findVehicleById(id);}

}
