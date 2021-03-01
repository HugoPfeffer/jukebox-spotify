package br.com.cmms.db;

import java.util.ArrayList;

import br.com.cmms.model.User;

public class userDatabase {

    private static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        userDatabase.users = users;
    }

}
