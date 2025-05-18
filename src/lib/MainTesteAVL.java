package lib;
import appCaixaMercado.ComparadorProdutoPorCodigo;
import appCaixaMercado.ComparadorProdutoPorNome;
import appCaixaMercado.Produto;

public class MainTesteAVL {
    public static void main(String[] args){
        ComparadorProdutoPorCodigo comparadorProdutoCodigo = new ComparadorProdutoPorCodigo();
        ComparadorProdutoPorNome comparadorProdutoNome = new ComparadorProdutoPorNome();

        ArvoreBinaria<Produto> ab = new ArvoreBinaria<>(comparadorProdutoCodigo);
        ArvoreBinariaAVL<Produto> abAVL = new ArvoreBinariaAVL<>(comparadorProdutoCodigo);

        ab.adicionar(new Produto(1, "maca", 10.0));
        ab.adicionar(new Produto(2, "banana", 10.0));
        ab.adicionar(new Produto(3, "abacate", 10.0));
        ab.adicionar(new Produto(4, "uva", 10.0));
        ab.adicionar(new Produto(5, "mamao", 10.0));
        ab.adicionar(new Produto(6, "pepino", 10.0));
        ab.adicionar(new Produto(7, "melao", 10.0));
        ab.adicionar(new Produto(8, "pera", 10.0));
        abAVL.adicionar(new Produto(1, "maca", 10.0));
        abAVL.adicionar(new Produto(2, "banana", 10.0));
        abAVL.adicionar(new Produto(3, "abacate", 10.0));
        abAVL.adicionar(new Produto(4, "uva", 10.0));
        abAVL.adicionar(new Produto(5, "mamao", 10.0));
        abAVL.adicionar(new Produto(6, "pepino", 10.0));
        abAVL.adicionar(new Produto(7, "melao", 10.0));
        abAVL.adicionar(new Produto(8, "pera", 10.0));
        
        System.out.println();
        System.out.println("Altura das árvores:");
        System.out.println("Árvore Binária: \t" + ab.altura());
        System.out.println("Árvore Binária AVL: \t" + abAVL.altura());
        System.out.println();
        System.out.println("Árvore binária em nível:\n" + ab.caminharEmNivel());
        System.out.println("Árvore binária AVL em nível:\n" + abAVL.caminharEmNivel());
    }
}
