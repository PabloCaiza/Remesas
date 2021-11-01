package vehicle;

import javax.persistence.*;

@Entity
@Table(name = "camion")
@NamedQuery(name = "findAllVecicle",query = "select  v from Vehicle  v ")
@NamedQuery(name = "findVecicleById",query = "select  v from Vehicle  v where v.id=:id ")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "placa")
    private String plate;
    @Column(name = "unidad")
    private String unit;
    @Column(name = "marca")
    private String brand;
    @Column(name = "color")
    private String color;
    @Column(name = "modelo")
    private String modelo;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private VehicleType vehiculeType;

    public Vehicle() {
    }

    public Vehicle(String plate, String unit, String brand, String color, String modelo, VehicleType vehiculeType) {
        this.plate = plate;
        this.unit = unit;
        this.brand = brand;
        this.color = color;
        this.modelo = modelo;
        this.vehiculeType = vehiculeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehiculeType() {
        return vehiculeType;
    }

    public void setVehiculeType(VehicleType vehiculeType) {
        this.vehiculeType = vehiculeType;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
