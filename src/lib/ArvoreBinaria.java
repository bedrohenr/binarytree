/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador; 
  
    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }
    
    // https://elemarjr.com/clube-de-estudos/artigos/introducao-a-arvore-binaria-conceitos-terminologias-e-implementacao/
    @Override
    public void adicionar(T novoValor) {
        if(this.raiz == null){
            this.raiz = new No<T>(novoValor);
        }

        this.raiz = this.addRecursivo(this.raiz, novoValor);
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

        return noAtual;
    }

    @Override
    public T pesquisar(T valor) {
        return this.pesquisarRecursivo(valor, this.raiz, this.comparador);
    }

    // DUVIDA
    // Necessário mudar na interface para Comparator<T> para remover o typecast 
   @Override
    public T pesquisar(T valor, Comparator comparador) {
        return (T) this.pesquisarRecursivo(valor, this.raiz, comparador);
    }

    private T pesquisarRecursivo(T valor, No<T> noAtual, Comparator<T> comparador){
        if(noAtual != null){
            
            int compare = this.comparador.compare(noAtual.getValor(), valor);
            // System.out.println("Compare: " + valor + "  - " + noAtual.getValor() +" = " + compare );
            if(compare < 0 )
                return pesquisarRecursivo(valor, noAtual.getFilhoEsquerda(), comparador);
            else if(compare > 0)
                return pesquisarRecursivo(valor, noAtual.getFilhoDireita(), comparador);
            else
                return noAtual.getValor();
        }
        return null;
    }

    @Override
    public T remover(T valor) {
        return removerRecursivo(valor, this.raiz);
    }

    private T removerRecursivo(T valor, No<T> noAtual){
        if(noAtual != null){
            
            int compare = this.comparador.compare(noAtual.getValor(), valor);
            // System.out.println("Compare: " + valor + "  - " + noAtual.getValor() +" = " + compare );
            if(compare < 0 )
                return removerRecursivo(valor, noAtual.getFilhoEsquerda());
            else if(compare > 0)
                return removerRecursivo(valor, noAtual.getFilhoDireita());
            else{
                No<T> aux = null;
                if(noAtual.getFilhoDireita() != null){
                    noAtual.setValor(noAtual.getFilhoDireita().getValor());

                    // Verifica se pode adquirir a folha da direita ou esquerda
                    if(noAtual.getFilhoDireita().getFilhoDireita() != null){
                        aux = noAtual.getFilhoDireita().getFilhoDireita();
                    } else if(noAtual.getFilhoDireita().getFilhoEsquerda() != null){
                        aux = noAtual.getFilhoEsquerda().getFilhoEsquerda();
                    }
                    noAtual.setFilhoDireita(aux);
                    
                } else if (noAtual.getFilhoEsquerda() != null){
                    noAtual.setValor(noAtual.getFilhoEsquerda().getValor());

                    if(noAtual.getFilhoEsquerda().getFilhoDireita() != null){
                        aux = noAtual.getFilhoDireita().getFilhoDireita();
                    } else if(noAtual.getFilhoEsquerda().getFilhoEsquerda() != null){
                        aux = noAtual.getFilhoEsquerda().getFilhoEsquerda();
                    }
                    noAtual.setFilhoEsquerda(aux);
                }
                
                return valor;
                        
            }

        }
        return null;
    }

    @Override
    public int altura() {
        return alturaRecursivo(this.raiz);
    }

    private int alturaRecursivo(No<T> noAtual) {
        if (noAtual == null) {
            return -1; // Árvore vazia
        }
        int alturaEsquerda = alturaRecursivo(noAtual.getFilhoEsquerda());
        int alturaDireita = alturaRecursivo(noAtual.getFilhoDireita());

        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    
    @Override
    public int quantidadeNos() {
        return qtdNoRecursivo(this.raiz);
    }

    private int qtdNoRecursivo(No<T> noAtual) {
        if (noAtual == null) {
            return 0; // Árvore vazia
        }
        int alturaEsquerda = qtdNoRecursivo(noAtual.getFilhoEsquerda());
        int alturaDireita = qtdNoRecursivo(noAtual.getFilhoDireita());

        return alturaEsquerda + alturaDireita + 1;
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public String caminharEmOrdem() {
        this.emOrdem(this.raiz);
        return "";
    }

    private void emOrdem(No<T> noAtual){
        if(noAtual != null){
            emOrdem(noAtual.getFilhoEsquerda());
            System.out.println(noAtual.getValor() + " ");
            emOrdem(noAtual.getFilhoDireita());
        }
    }
}
