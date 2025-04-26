import lib.ArvoreBinaria;
import lib.ComparadorInteiro;

public class Main {
    public static void main(String[] args){
        ComparadorInteiro comp = new ComparadorInteiro();
        ArvoreBinaria<Integer> tree = new ArvoreBinaria<>(comp);

        tree.adicionar(4);
        tree.adicionar(5);
        tree.adicionar(6);
        tree.adicionar(7);
        tree.adicionar(1);
        tree.adicionar(2);
        tree.adicionar(3);

        tree.caminharEmOrdem();
        System.out.println("--");
        System.out.println("Pesquisar: " + tree.pesquisar(6));
    }
}
