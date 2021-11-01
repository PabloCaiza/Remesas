package user;


import remesa.Remesa;

import javax.inject.Named;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@NamedQuery(name = "findUserByUsername",query = "select  u from User  u WHERE  u.email=:username")
@NamedQuery(name = "findAllUser",query = "select  u from User  u ")
@NamedQuery(name = "findUserById",query = "select u from User  u where u.id=:id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "correo")
    private String email;
    @Column(name = "nombre")
    private String name;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private UserType userType;
    @OneToMany(mappedBy = "sender",fetch = FetchType.LAZY)
    private List<Remesa> remesas;

    public User(String email, String name, String password, UserType userType) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Remesa> getRemesas() {
        return remesas;
    }

    public void setRemesas(List<Remesa> remesas) {
        this.remesas = remesas;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
