package user;

import session.SessionController;
import util.CommonUtils;

import javax.annotation.PostConstruct;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Named
@ViewScoped
public class UserController implements Serializable {

    @Inject
    private UserService userService;
    @Inject
    private SessionController sessionController;
    private String username = "";
    private String password = "";
    private User newUser;
    private List<User> users;
    private UserType[] typesOfClients;
    private User selectedUser;

    @PostConstruct
    public void init() {
        newUser = new User();
        users = userService.getUsers();
        typesOfClients = UserType.values();
        selectedUser = new User();
    }


    public void login() {
        try {
            User user = userService.validateUser(username, password);
            if (user != null) {
                sessionController.setUser(user);
                CommonUtils.redirectPage("home.xhtml");
            } else {
                CommonUtils.addMessage(FacesMessage.SEVERITY_WARN, "Credenciales Incorectas", "verifique " +
                        "sus credenciales");
            }

        } catch (Exception e) {
            CommonUtils.addMessage(FacesMessage.SEVERITY_WARN, "Credenciales Incorectas", "verifique " +
                    "sus credenciales");
        }

    }

    public void createUser() {
        userService.createUser(selectedUser);
        users = userService.getUsers();
    }

    public void deleteUser(User user) {
        userService.deleteUser(user);
        users = userService.getUsers();
    }

    public void selectUser(User user) {
        selectedUser = user;
    }

    public void selectUser() {
        selectedUser = new User();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserType[] getTypesOfClients() {
        return typesOfClients;
    }

    public void setTypesOfClients(UserType[] typesOfClients) {
        this.typesOfClients = typesOfClients;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
