package menu;

public class MenuItem {
    private String name;
    private boolean adminAllowed;
    private String page;

    public MenuItem(String name, boolean adminAllowed, String page) {
        this.name = name;
        this.adminAllowed = adminAllowed;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdminAllowed() {
        return adminAllowed;
    }

    public void setAdminAllowed(boolean adminAllowed) {
        this.adminAllowed = adminAllowed;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", adminAllowed=" + adminAllowed +
                ", page='" + page + '\'' +
                '}';
    }
}
