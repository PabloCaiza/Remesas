package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;

public class CommonUtils {

    public static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public static void redirectPage(String url) throws IOException {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect(url);

    }
}
