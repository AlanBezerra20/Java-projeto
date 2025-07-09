import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public Pessoa(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Email: " + email;
    }
}

public class SistemaAcademia {
    private static Map<String, Pessoa> usuarios = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== SISTEMA DA ACADEMIA =====");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Fazer login");
            System.out.println("3. Listar todos os usuários (teste)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    fazerLogin();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarUsuario() {
        System.out.println("\n--- Cadastro de Usuário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (usuarios.containsKey(email)) {
            System.out.println("Erro: Já existe um usuário com esse email.");
            return;
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Pessoa novaPessoa = new Pessoa(nome, cpf, email, senha);
        usuarios.put(email, novaPessoa);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void fazerLogin() {
        System.out.println("\n--- Login ---");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Pessoa usuario = usuarios.get(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuario.getNome());
        } else {
            System.out.println("Email ou senha incorretos!");
        }
    }

    private static void listarUsuarios() {
        System.out.println("\n--- Lista de Usuários Cadastrados ---");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Pessoa p : usuarios.values()) {
                System.out.println(p);
            }
        }
    }
}
