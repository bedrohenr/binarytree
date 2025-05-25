package lib;

import java.util.Comparator;

public class ArvoreBinariaAVL<T> extends ArvoreBinaria<T>{

    public ArvoreBinariaAVL(Comparator<T> comparator) {
        super(comparator);
    }
    
    //Implementar métodos para efetuar o balanceamento e sobrescrever método de adicionar elemento...
    @Override
    public void adicionar(T novoValor) {
        if(this.raiz == null){
            this.raiz = new No<T>(novoValor);
        }

        this.raiz = this.addRecursivo(this.raiz, novoValor);
    }

    @Override
    public T remover(T valor){
        this.raiz = this.removerRecursivo(this.raiz, valor);
        return valor;
    }

    private No<T> addRecursivo(No<T> noAtual, T valor){

        if(noAtual == null){
            return new No<T>(valor);
        }

        int compare = this.comparador.compare(noAtual.getValor(), valor);

        // valor menor -> insere a esquerda
        if( compare < 0) {
            noAtual.setFilhoEsquerda(addRecursivo(noAtual.getFilhoEsquerda(), valor));
        }
        // valor maior -> insere a direita
        else if ( compare > 0) {
            noAtual.setFilhoDireita(addRecursivo(noAtual.getFilhoDireita(), valor));
        }

        // Atualiza a altura do nó atual
        this.atualizaAltura(noAtual);

        // Verifica os nós que necessitam de balanceamento
        No<T> noRetorno = rotacoes(noAtual, compare);

        if(noRetorno != null) {
            return noRetorno;
        }

        return noAtual;
    }

    public No<T> removerRecursivo(No<T> noAtual, T valor){
        if(noAtual == null)
            return null;
        
        int compare = this.comparador.compare(noAtual.getValor(), valor);

        
        if( compare < 0) {
            noAtual.setFilhoEsquerda(removerRecursivo(noAtual.getFilhoEsquerda(), valor));
        } else if ( compare > 0) {
            noAtual.setFilhoDireita(removerRecursivo(noAtual.getFilhoDireita(), valor));
        } else {
            // Nó com um filho
            if(noAtual.getFilhoEsquerda() == null)
                return noAtual.getFilhoDireita();
            else if(noAtual.getFilhoDireita() == null)
                return noAtual.getFilhoEsquerda();

            // Nó com dois filhos
            No<T> temp = noValorMinimo(noAtual.getFilhoDireita());
            noAtual.setValor(temp.getValor());

            noAtual.setFilhoDireita(removerRecursivo(noAtual.getFilhoDireita(), temp.getValor()));


        }

        // Atualiza altura e faz balanceamento
        if(noAtual != null){
            atualizaAltura(noAtual);
            return rotacoes(noAtual, compare);
        }

        return noAtual;
    }

    public No<T> rotacoes(No<T> noAtual, int compare) {
        // Verifica o balanceamento do nó atual
        int balanceamento = this.calcularBalanceamento(noAtual);

        // Se o nó estiver desbalanceado, verifica qual tipo de rotação deve ser feita
        if (balanceamento > 1 && compare < 0) {
            return this.rotacaoDireita(noAtual);
        }
        if (balanceamento < -1 && compare > 0) {
            return this.rotacaoEsquerda(noAtual);
        }
        if (balanceamento > 1 && compare >= 0) {
            noAtual.setFilhoEsquerda(rotacaoEsquerda(noAtual.getFilhoEsquerda()));
            return this.rotacaoDireita(noAtual);
        }
        if (balanceamento < -1 && compare <= 0) {
            noAtual.setFilhoDireita(rotacaoDireita(noAtual.getFilhoDireita()));
            return this.rotacaoEsquerda(noAtual);
        }

        return noAtual;
    }

    private No<T> noValorMinimo(No<T> noAtual){
        No<T> menor = noAtual;
        while(noAtual.getFilhoEsquerda() != null){
            menor = menor.getFilhoEsquerda();
        }

        return menor;
    }

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
