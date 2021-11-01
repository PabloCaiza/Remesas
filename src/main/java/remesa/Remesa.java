package remesa;


import agent.Agent;
import user.User;
import vehicle.Vehicle;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "remesa")
@NamedQuery(name = "findRemesaByState",query = "select  r from Remesa r where r.state=:state")
@NamedQuery(name = "findRemesaByUser",query = "select r from Remesa  r where r.sender=:sender")
public class Remesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "valor")
    private double value;
    @Column(name = "estado")
    private boolean state;
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private RemesaType type;
    @Column(name = "fecha")
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_emisor")
    private User sender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receptor")
    private User receiver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_camion")
    private Vehicle vehicle;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "agente_remesa",
            joinColumns = {@JoinColumn(name = "id_remesa")},
            inverseJoinColumns = {@JoinColumn(name = "id_agente")}
    )
    private List<Agent> agents;

    public Remesa(double value, boolean state, RemesaType type) {
        this.value = value;
        this.state = state;
        this.type = type;
    }


    public Remesa() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public RemesaType getType() {
        return type;
    }

    public void setType(RemesaType type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

}
