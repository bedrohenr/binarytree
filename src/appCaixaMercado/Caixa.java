package appCaixaMercado;

import java.util.Scanner;

public abstract class Caixa {

    public static Produto adicionarProduto(Scanner scanner) {
        System.out.println("\n--- ADICIONAR PRODUTO ---");

        System.out.print("Código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        
        Produto produto = new Produto(codigo, nome, preco);
        System.out.println("Produto criado!");

        return produto;
    }

    public static Produto removerProduto(Scanner scanner, String produtos){
        System.out.println("\n--- PROCURAR POR NOME ---");
        System.out.println(produtos);

        System.out.print("Digite o código do produto que deseja remover: ");
        int codigo = scanner.nextInt();
    
        return new Produto(codigo, "", 0);
    }

    public static Produto procurarPorCodigo(Scanner scanner) {
        System.out.println("\n--- PROCURAR POR CÓDIGO ---");

        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        
        return new Produto(codigo, "", 0);
    }

    public static Produto procurarPorNome(Scanner scanner) {
        System.out.println("\n--- PROCURAR POR NOME ---");

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine().toLowerCase();
        
        return new Produto(0, nome, 0);
    }

    public static void listarProdutos(String produtos){
        System.out.println("\n--- PROCURAR POR NOME ---");
        System.out.println(produtos);
    }
}