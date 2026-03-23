package br.com.estudo.model;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private final List<Usuario> users = new ArrayList<>();

    public void addUser(Usuario user) {
        users.add(user);
    }

    public List<Usuario> getUsers() {
        return users;
    }

    public Usuario searchByEmail(String email){
        for(Usuario user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
