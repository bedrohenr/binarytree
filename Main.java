import java.util.Scanner;

import appCaixaMercado.Caixa;
import appCaixaMercado.ComparadorProdutoPorCodigo;
import appCaixaMercado.ComparadorProdutoPorNome;
import appCaixaMercado.Produto;
import lib.ArvoreBinaria;

public class Main {
    public static void main(String[] args){
        ComparadorProdutoPorCodigo comparadorProdutoCodigo = new ComparadorProdutoPorCodigo();
        ComparadorProdutoPorNome comparadorProdutoNome = new ComparadorProdutoPorNome();

        ArvoreBinaria<Produto> arvoreBinaria = new ArvoreBinaria<>(comparadorProdutoCodigo);

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== CAIXA DE MERCADO ===");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Procurar produto por código");
            System.out.println("4. Procurar produto por nome");
            System.out.println("5. Listar todos os produtos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1:
                    Produto p = Caixa.adicionarProduto(scanner);
                    arvoreBinaria.adicionar(p);

                    break;
                case 2:
                    Produto produtoCodigo = Caixa.removerProduto(scanner, arvoreBinaria.caminharEmOrdem());
                    if(produtoCodigo != null){
                        Produto produtoRemover = arvoreBinaria.pesquisar(produtoCodigo);
                        arvoreBinaria.remover(produtoRemover);
                    } else 
                        System.out.println("Código inválido!");   
                    
                    break;
                case 3:
                    Produto produtoPesquisaCodigo = Caixa.procurarPorCodigo(scanner);
                    Produto produtoEncontradoCodigo = arvoreBinaria.pesquisar(produtoPesquisaCodigo);
                    System.out.println("Produto encontrado: " + produtoEncontradoCodigo);

                    break;
                case 4:
                    Produto produtoPesquisaNome = Caixa.procurarPorNome(scanner);
                    Produto produtoEncontradoNome = arvoreBinaria.pesquisar(produtoPesquisaNome, comparadorProdutoNome);
                    System.out.println("Produto encontrado: " + produtoEncontradoNome);

                    break;
                case 5:
                    Caixa.listarProdutos(arvoreBinaria.caminharEmOrdem());

                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    scanner.close();

                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
