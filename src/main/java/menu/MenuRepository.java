package menu;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class MenuRepository {

    public List<MenuItem> getAllMenuItems() {
        return Arrays.asList(new MenuItem("Administracion de Usuarios", true,"usuario.xhtml"),
                new MenuItem("Administracion de Camiones", true,"camion.xhtml"),
                new MenuItem("Solicitar Remesa",false,"solicitarRemesa.xhtml"),
                new MenuItem("Administracion de Agentes",true,"agente.xhtml"),
                new MenuItem("Autorizacion de Remesa",true,"autorizarRemesa.xhtml"),
                new MenuItem("Verificar Remesa",false,"verificarRemesa.xhtml"));
    }
}
