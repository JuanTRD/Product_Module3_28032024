package Model;

import Model.subModel.Role;

public class User {
    private int id;
    private String username;
    private String password;
    private int IdRole;

    public User() {
    }

    public User(int id, String username, String password, int IdRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.IdRole = IdRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int idRole) {
        IdRole = idRole;
    }
}
