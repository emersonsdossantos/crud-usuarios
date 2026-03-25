package br.com.estudo.model;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private int nextId = 1;
    private final List<Usuario> users = new ArrayList<>();

    public void addUser(Usuario user) {
        user.setId(nextId);
        users.add(user);
        nextId++;
    }

    public List<Usuario> getUsers() {
        return users;
    }

    public Usuario searchById(int id){
        for(Usuario user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public Usuario searchByEmail(String email){
        for(Usuario user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public boolean deleteByEmail(String email){
        Usuario user = searchByEmail(email);
        if(user == null){
            return false;
        }
       users.remove(user);
        return true;
    }

    public boolean deleteById(int id){
        Usuario user = searchById(id);
        if(user == null){
            return false;
        }
        users.remove(user);
        return true;
    }

}
