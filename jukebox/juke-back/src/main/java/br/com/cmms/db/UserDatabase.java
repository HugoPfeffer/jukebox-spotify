package br.com.cmms.db;

import java.util.ArrayList;
import java.util.List;

import br.com.cmms.model.User;

public final class UserDatabase {
    
    private UserDatabase() {
        //not called
    }
    

    private static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UserDatabase.users = users;
    }

  



}
