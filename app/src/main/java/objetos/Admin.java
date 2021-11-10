package objetos;

public class Admin {
    private int id;
    private String user;
    private String pass;

    public Admin()
    {
        user = "Admin"; //Iniciacion de variables user y pass
        pass = "1234";
    }

    public Admin(int id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
