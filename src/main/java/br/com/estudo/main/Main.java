package br.com.estudo.main;

import br.com.estudo.model.UserManager;
import br.com.estudo.model.Usuario;

public class Main {
    public static void main(String[] args) {

        Usuario user1 = new Usuario("Joao", "joao@teste.com", 40);
        Usuario user2 = new Usuario("Maria", "maria@teste.com", 20);
        Usuario user3 = new Usuario("Pedro", "pedro@teste.com", 30);

        UserManager manager = new UserManager();
        manager.addUser(user1);
        manager.addUser(user2);
        manager.addUser(user3);

        for(Usuario user : manager.getUsers()){
            System.out.println(user);
        }

        Usuario userFound = manager.searchByEmail("maria@teste.com");
        if(userFound != null){
            System.out.println(userFound);
        } else{
            System.out.println("Usuário não encontrado");
        }

        boolean removed = manager.deleteByEmail("maria@teste.com");
        if(removed){
            System.out.println("Usuario removido");
        } else{
            System.out.println("Usuario não encontrado");
        }
        System.out.println("=== LISTA APÓS DELETE ===");
        for(Usuario user : manager.getUsers()){
            System.out.println(user);
        }

        boolean update = manager.updateById(3, "Pedrinho", "pedrinho@teste.com", 31);
        if(update){
            System.out.println("Usuario atualizado!!!!");
        }else{
            System.out.println("Usuario não encontrado.");
        }
        System.out.println("=== LISTA APÓS ATUALIZAÇÃO ===");
        for(Usuario user : manager.getUsers()){
            System.out.println(user);
        }
    }
}
