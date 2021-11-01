package session;


import user.User;
import util.CommonUtils;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionController implements Serializable {
    private User user;

    public String closeSession() {
        try {

            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "login.xhtml?faces-redirect=true";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}


