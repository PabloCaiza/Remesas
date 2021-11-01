package remesa;

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
public class AuthorizeRemesaController implements Serializable {
    @Inject
    private RemesaService remesaService;
    private List<Remesa> remesas;
    private Remesa selectedRemesa;
    private boolean showDate;
    @Inject


    @PostConstruct
    public void init() {
        selectedRemesa = new Remesa();
        remesas = remesaService.getRemesasByState(false);
        showDate=false;
    }

    public void authorizeRemesa() {
        if (!showDate)
            return;
        if(selectedRemesa.getDate()==null){
            CommonUtils.addMessage(FacesMessage.SEVERITY_ERROR,"fecha es requerida","ingrese una fecha");
            return;
        }
        selectedRemesa.setState(true);
        remesaService.updateRemesa(selectedRemesa);
        selectedRemesa=new Remesa();
        remesas=remesaService.getRemesasByState(false);
        CommonUtils.addMessage(FacesMessage.SEVERITY_INFO,"Succesful","remesa autorizada");
    }

    public void selectRemesa(Remesa remesa) {
        selectedRemesa = remesa;
        showDate = false;
    }

    public List<Remesa> getRemesas() {
        return remesas;
    }


    public void setRemesas(List<Remesa> remesas) {
        this.remesas = remesas;
    }

    public Remesa getSelectedRemesa() {
        return selectedRemesa;
    }

    public void setSelectedRemesa(Remesa selectedRemesa) {
        this.selectedRemesa = selectedRemesa;
    }

    public boolean getShowDate() {
        return showDate;
    }

    public void setShowDate(boolean showDate) {
        this.showDate = showDate;
    }
}
