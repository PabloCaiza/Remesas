package agent;

import javax.persistence.*;

@Entity
@Table(name = "agente")
@NamedQuery(name = "findAllAgents",query = "select  a from Agent  a ")
@NamedQuery(name="filterAgents",query = "select a from Agent  a  where lower(a.name) like  :filter   or lower(a.cedula) like :filter or lower(a.lastName) like :filter or lower(a.agentType) like :filter "
        )
@NamedQuery(name = "findIdsOfAgents",query = "select a.id from Agent  a")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "fotografia")
    private byte[] image;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private AgentType agentType;

    public Agent() {
    }

    public Agent(String cedula, String name, String lastName, byte[] image, AgentType agentType) {
        this.cedula = cedula;
        this.name = name;
        this.lastName = lastName;
        this.image = image;
        this.agentType = agentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public AgentType getAgentType() {
        return agentType;
    }

    public void setAgentType(AgentType agentType) {
        this.agentType = agentType;
    }
}
