import appCaixaMercado.ComparadorProdutoPorCodigo;
import appCaixaMercado.ComparadorProdutoPorNome;
import appCaixaMercado.Produto;
import lib.ArvoreBinaria;

public class Main {
    public static void main(String[] args){
        ComparadorProdutoPorCodigo comparadorProdutoCodigo = new ComparadorProdutoPorCodigo();
        ComparadorProdutoPorNome comparadorProdutoNome = new ComparadorProdutoPorNome();

        ArvoreBinaria<Produto> arvoreBinaria = new ArvoreBinaria<>(comparadorProdutoCodigo);

        Produto notebook = new Produto(12313, "Notebook", 3500.00f);
        Produto phone = new Produto(15442, "Smartphone", 1999.90f);
        Produto tablet = new Produto(11332, "Tablet", 1200.50f);
        Produto foneOuvido = new Produto(10224, "Fone Bluetooth", 299.90f);
        Produto mouse = new Produto(14332, "Mouse Gamer", 250.00f);

        arvoreBinaria.adicionar(mouse);
        arvoreBinaria.adicionar(notebook);
        arvoreBinaria.adicionar(tablet);
        arvoreBinaria.adicionar(phone);
        arvoreBinaria.adicionar(foneOuvido);

        arvoreBinaria.caminharEmOrdem();
        System.out.println();
        System.out.println("Pesquisar: " + arvoreBinaria.pesquisar(tablet));
        System.out.println("Pesquisar por Nome: " + arvoreBinaria.pesquisar(mouse, comparadorProdutoNome));
        System.out.println();
        System.out.println("Quantidade de nos: " + arvoreBinaria.quantidadeNos());
        System.out.println();
        System.out.println("Em nivel: " + arvoreBinaria.caminharEmNivel());
    }
}
