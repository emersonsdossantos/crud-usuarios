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

    //BUSCAR POR ID
    public Usuario searchById(int id){
        for(Usuario user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    //BUSCAR POR EMAIL
    public Usuario searchByEmail(String email){
        for(Usuario user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    //DELETE POR EMAIL
    public boolean removeByEmail(String email){
        Usuario user = searchByEmail(email);
        if(user == null){
            return false;
        }
       users.remove(user);
        return true;
    }

    //DELETE POR ID
    public boolean removeById(int id){
        Usuario user = searchById(id);
        if(user == null){
            return false;
        }
        users.remove(user);
        return true;
    }

    //UPDATE POR ID
    public boolean updateById(int id, String novoNome, String novoEmail, int novaIdade){
        Usuario user = searchById(id);
        if(user == null){
            return false;
        }
        user.setNome(novoNome);
        user.setEmail(novoEmail);
        user.setIdade(novaIdade);
        return true;
    }
}
