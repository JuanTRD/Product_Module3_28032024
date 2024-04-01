package Service;

import Model.Product;
import Model.User;
import Model.subModel.Role;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();

    public UserService() {
    }
    public void add(User user) {

    }
    public List<User> viewAll() {
        return null;
    }
    public boolean checkUser(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername()) && password.equals(userList.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkRole(String username, Role role) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())&& role.equals(userList.get(i).getRole())) {
                return true;
            }
        }
        return false;
    }
    public void edit(int id, User user) {
    }


    public void delete(int id) {
    }

    public int findIndexById(int id) {
        return -1;
    }

    public User findById(int id) {
        return null;
    }

    public int getIdUser(String username, String password) {
        ;
    }
}
