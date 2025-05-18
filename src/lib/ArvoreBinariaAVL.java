package lib;

import java.util.Comparator;

public class ArvoreBinariaAVL<T> extends ArvoreBinaria<T>{

    public ArvoreBinariaAVL(Comparator<T> comparator) {
        super(comparator);
    }
    
    //Implementar métodos para efetuar o balanceamento e sobrescrever método de adicionar elemento...
    private int getAltura(No<T> no) {
        if(no == null) {
            return 0;
        }
        return no.getAltura();
    }
}
