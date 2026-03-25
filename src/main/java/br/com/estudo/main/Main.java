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

        listUsers(manager);

        Usuario userFound = manager.searchByEmail("maria@teste.com");
        if(userFound != null){
            System.out.println(userFound);
        } else{
            System.out.println("Usuário não encontrado.");
        }

        boolean remove = manager.removeByEmail("maria@teste.com");
        if(remove){
            System.out.println("Usuario removido com sucesso.");
        } else{
            System.out.println("Usuario não encontrado.");
        }
        System.out.println("=== LISTA APÓS DELETE VIA EMAIL===");
        listUsers(manager);

        boolean removeUser = manager.removeById(1);
        if(removeUser){
            System.out.println("Usuario removido com sucesso.");
        }else{
            System.out.println("Usuario nao encontrado.");
        }
        System.out.println("=== LISTA APÓS DELETE VIA ID ===");
        listUsers(manager);

        boolean update = manager.updateById(3, "Pedrinho", "pedrinho@teste.com", 31);
        if(update){
            System.out.println("Usuario atualizado!!!!");
        }else{
            System.out.println("Usuario não encontrado.");
        }
        System.out.println("=== LISTA APÓS ATUALIZAÇÃO ===");
        listUsers(manager);
    }
    public static void listUsers(UserManager manager){
        for(Usuario user : manager.getUsers()){
            System.out.println(user);
        }
    }
}
