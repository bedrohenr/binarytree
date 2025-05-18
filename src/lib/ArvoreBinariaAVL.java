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

    private No<T> rotacaoDireita(No<T> noAtual) {
        No<T> filhoEsquerda = noAtual.getFilhoEsquerda();
        No<T> direitaFilhoEsquerda = filhoEsquerda.getFilhoDireita();

        filhoEsquerda.setFilhoDireita(noAtual);
        noAtual.setFilhoEsquerda(direitaFilhoEsquerda);

        this.atualizaAltura(noAtual);
        this.atualizaAltura(filhoEsquerda);
        

        return filhoEsquerda;
    }

    private No<T> rotacaoEsquerda(No<T> noAtual) {
        No<T> filhoDireita = noAtual.getFilhoDireita();
        No<T> esquerdaFilhoDireita = filhoDireita.getFilhoEsquerda();

        filhoDireita.setFilhoEsquerda(noAtual);
        noAtual.setFilhoDireita(esquerdaFilhoDireita);

        this.atualizaAltura(noAtual);
        this.atualizaAltura(filhoDireita);

        return filhoDireita;
    }
}
