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
            No<T> novoNo = new No<T>(valor);
            // noAtual = novoNo;
            // System.out.println("TESTE NO: " + noAtual.getValor());
            return novoNo;
        }

        int compare = this.comparador.compare(noAtual.getValor(), valor);

        // valor menor -> insere a esquerda
        if( compare < 0) {
            System.out.println("FLAG LEFT");
            noAtual.setFilhoEsquerda(addRecursivo(noAtual.getFilhoEsquerda(), valor));
        }
        // valor maior -> insere a direita
        else if ( compare > 0) {
            System.out.println("FLAG RIGHT");
            noAtual.setFilhoDireita(addRecursivo(noAtual.getFilhoDireita(), valor));
        }

        return noAtual;
    }

    @Override
    public T pesquisar(T valor) {
        No<T> noAtual = raiz;
        while(true){
            T noAtualValor = noAtual.getValor();
            if(this.comparador.compare(valor, noAtualValor) == 1){
                if(noAtual.getFilhoEsquerda() == null) {
                    return noAtual.getFilhoEsquerda().getValor();
                }
                noAtual = noAtual.getFilhoEsquerda();
            } else {
                if(noAtual.getFilhoDireita() == null) {
                    return noAtual.getFilhoDireita().getValor();
                }
                noAtual = noAtual.getFilhoDireita();
            }
        }
    }

   @Override
    public T pesquisar(T valor, Comparator comparador) {
        No noAtual = raiz;
        while(true){
            T noAtualValor = (T) noAtual.getValor();
            if(comparador.compare(valor, noAtualValor) == 1){
                if(noAtual.getFilhoEsquerda() == null) {
                    return (T) noAtual.getFilhoEsquerda().getValor();
                }
                noAtual = noAtual.getFilhoEsquerda();
            } else {
                if(noAtual.getFilhoDireita() == null) {
                    return (T) noAtual.getFilhoDireita().getValor();
                }
                noAtual = noAtual.getFilhoDireita();
            }
        }
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    
    @Override
    public int quantidadeNos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public String caminharEmOrdem() {
        System.out.println("Init caminhar em ordem");
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
