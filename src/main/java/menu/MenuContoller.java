package menu;

import session.SessionController;
import user.UserService;
import user.UserType;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class MenuContoller implements Serializable {
    @Inject
    private SessionController sessionController;
    @Inject
    private MenuRepository menuRepository;
    private List<MenuItem> menuItems;


    @PostConstruct
    public void init(){

        menuItems=menuRepository.getAllMenuItems()
                .stream()
                .filter(menuItem -> {
                    if (sessionController.getUser().getUserType().name().equals(UserType.ADMINISTRADOR.name())){
                        return menuItem.isAdminAllowed();
                    }
                    return !menuItem.isAdminAllowed();
                }).collect(Collectors.toList());
    }


    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }



}
