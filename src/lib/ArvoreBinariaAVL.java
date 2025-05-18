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
    private void atualizaAltura(No<T> no) {
        int altura = 1 + Math.max(this.getAltura(no.getFilhoEsquerda()), this.getAltura(no.getFilhoDireita()));

        no.setAltura(altura);
    }

    private int calcularBalanceamento(No<T> no) {
        if (no == null) {
            return 0;
        } else {
            return this.getAltura(no.getFilhoEsquerda()) - this.getAltura(no.getFilhoDireita());
        }
        
    }

}
