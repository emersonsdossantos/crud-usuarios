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

        while (continuar){
            System.out.println("0 - Sair");
            System.out.println("1 - Listar Usuarios");
            System.out.println("2 - Cadastrar Usuario");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar Usuário");
            System.out.println("5 - Remover Usuário");

            opcao = scan.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Sistema Encerrado");
                    continuar = false;
                    break;
                case 1:
                    listUsers(manager);
                    break;
                case 2:
                    scan.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Digite o email: ");
                    String email = scan.nextLine();
                    System.out.print("Digite a idade: ");
                    int idade = scan.nextInt();
                    manager.addUser(new Usuario(nome, email, idade));
                    System.out.println("Usuário cadastrado com sucesso");
                    break;
                case 3:
                    System.out.print("Informe o ID: ");
                    int id = scan.nextInt();
                    Usuario userFound = manager.searchById(id);
                    if(userFound != null){
                        System.out.println(userFound);
                    } else{
                        System.out.println("Usuario não encontrado");
                    }
                    break;
                case 4:
                    System.out.print("Informe o Id do usuario: ");
                    int userId = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Informe o nome: ");
                    String novoNome = scan.nextLine();
                    System.out.print("Informe o email: ");
                    String novoEmail = scan.nextLine();
                    System.out.print ("Informe a idade: ");
                    int novaIdade = scan.nextInt();
                    boolean update = manager.updateById(userId, novoNome, novoEmail, novaIdade);
                    if(update){
                        System.out.println("Usuario atualizado com sucesso!");
                    } else{
                        System.out.println("Usuario não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Informe o id do usuario: ");
                    int idToRemoved = scan.nextInt();
                    boolean removed = manager.removeById(idToRemoved);
                    if(removed){
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuario não encontrado");
                    }
                    break;
                default:
                    System.out.println("Opção Invalida");
            }
        }

        scan.close();
    }
    public static void listUsers(UserManager manager){
        for(Usuario user : manager.getUsers()){
            System.out.println(user);
        }
    }
}
