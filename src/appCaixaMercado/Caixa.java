package appCaixaMercado;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Caixa {

    public static Produto adicionarProduto(Scanner scanner) {
        System.out.println("\n--- ADICIONAR PRODUTO ---");
        
        try {
            System.out.print("Código do produto: ");
            int codigo = 0;
            while (true) {
                try {
                    codigo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    if (codigo <= 0) {
                        System.out.print("Código deve ser positivo. Digite novamente: ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Valor inválido! Digite um número inteiro para o código: ");
                    scanner.nextLine(); // Limpar buffer
                }
            }

            System.out.print("Nome do produto: ");
            String nome = "";
            while (nome.trim().isEmpty()) {
                nome = scanner.nextLine();
                if (nome.trim().isEmpty()) {
                    System.out.print("Nome não pode ser vazio! Digite novamente: ");
                }
            }

            System.out.print("Preço do produto: ");
            double preco = 0;
            while (true) {
                try {
                    preco = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer
                    if (preco <= 0) {
                        System.out.print("Preço deve ser positivo. Digite novamente: ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Valor inválido! Digite um número para o preço: ");
                    scanner.nextLine(); // Limpar buffer
                }
            }
            
            Produto produto = new Produto(codigo, nome, preco);
            System.out.println("Produto criado com sucesso!");
            return produto;

        } catch (Exception e) {
            System.out.println("Erro inesperado ao adicionar produto: " + e.getMessage());
            scanner.nextLine(); // Limpar buffer
            return null;
        }
    }

    public static Produto removerProduto(Scanner scanner, String produtos) {
        System.out.println("\n--- REMOVER PRODUTO ---");
        
        try {
            if (produtos == null || produtos.isEmpty()) {
                System.out.println("Nenhum produto disponível para remoção.");
                return null;
            }

            System.out.println(produtos);
            System.out.print("Digite o código do produto que deseja remover: ");
            
            int codigo = 0;
            while (true) {
                try {
                    codigo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    if (codigo <= 0) {
                        System.out.print("Código inválido! Digite um número positivo: ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Entrada inválida! Digite um número para o código: ");
                    scanner.nextLine(); // Limpar buffer
                }
            }
            
            if(codigo == 0)
                return null;    
            return new Produto(codigo, "", 0);

        } catch (Exception e) {
            System.out.println("Erro inesperado ao remover produto: " + e.getMessage());
            scanner.nextLine(); // Limpar buffer
            return null;
        }
    }

    public static Produto procurarPorCodigo(Scanner scanner) {
        System.out.println("\n--- PROCURAR POR CÓDIGO ---");
        
        try {
            System.out.print("Digite o código do produto: ");
            
            int codigo = 0;
            while (true) {
                try {
                    codigo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    if (codigo <= 0) {
                        System.out.print("Código inválido! Digite um número positivo: ");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Entrada inválida! Digite um número para o código: ");
                    scanner.nextLine(); // Limpar buffer
                }
            }
            
            return new Produto(codigo, "", 0);

        } catch (Exception e) {
            System.out.println("Erro inesperado ao procurar por código: " + e.getMessage());
            scanner.nextLine(); // Limpar buffer
            return null;
        }
    }

    public static Produto procurarPorNome(Scanner scanner) {
        System.out.println("\n--- PROCURAR POR NOME ---");
        
        try {
            System.out.print("Digite o nome do produto: ");
            String nome = "";
            while (nome.trim().isEmpty()) {
                nome = scanner.nextLine();
                if (nome.trim().isEmpty()) {
                    System.out.print("Nome não pode ser vazio! Digite novamente: ");
                }
            }
            
            return new Produto(0, nome.toLowerCase(), 0);

        } catch (Exception e) {
            System.out.println("Erro inesperado ao procurar por nome: " + e.getMessage());
            return null;
        }
    }

    public static void listarProdutos(String produtos) {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        
        try {
            if (produtos == null || produtos.isEmpty()) {
                System.out.println("Nenhum produto cadastrado.");
            } else {
                System.out.println(produtos);
            }
        } catch (Exception e) {
            System.out.println("Erro ao exibir lista de produtos: " + e.getMessage());
        }
    }
}