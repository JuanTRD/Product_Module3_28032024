package Model;

import Model.subModel.Role;

public class User {
    private int id;
    private String username;
    private String password;
    private int role;

    public User() {
    }

    public User(int id, String username, String password, int IdRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
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
        return role;
    }

    public void setIdRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return null;
    }

    public String getPassword() {
        ;
    }
}
