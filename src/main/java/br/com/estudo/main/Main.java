package br.com.estudo.main;

import br.com.estudo.model.UserManager;
import br.com.estudo.model.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcao;
        boolean continuar = true;
        Scanner scan = new Scanner(System.in);

        Usuario user1 = new Usuario("Joao", "joao@teste.com", 40);
        Usuario user2 = new Usuario("Maria", "maria@teste.com", 20);
        Usuario user3 = new Usuario("Pedro", "pedro@teste.com", 30);

        UserManager manager = new UserManager();
        manager.addUser(user1);
        manager.addUser(user2);
        manager.addUser(user3);

        listUsers(manager);
        while (continuar){
            System.out.println("0 - Sair");
            System.out.println("1 - Listar Usuarios");

            opcao = scan.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Sistema Encerrado");
                    continuar = false;
                    break;
                case 1:
                    listUsers(manager);
                    break;
                    break;
                default:
                    System.out.println("Opção Invalida");
            }
        }

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
