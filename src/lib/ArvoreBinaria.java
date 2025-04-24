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
        No novoNo = new No(novoValor);

        if(raiz == null){
            raiz = novoNo;
        } else {
            No noAtual = raiz;
            while(true){
                T noAtualValor = (T) noAtual.getValor();
                if(this.comparador.compare(novoValor, noAtualValor) == 1){
                    if(noAtual.getFilhoEsquerda() == null) {
                        noAtual.setFilhoEsquerda(novoNo);
                        break;
                    }
                    noAtual = noAtual.getFilhoEsquerda();
                } else {
                    if(noAtual.getFilhoDireita() == null) {
                        noAtual.setFilhoDireita(novoNo);
                        break;
                    }
                    noAtual = noAtual.getFilhoDireita();
                }
            }
             
        }
    }

    @Override
    public T pesquisar(T valor) {
        No noAtual = raiz;
        while(true){
            T noAtualValor = (T) noAtual.getValor();
            if(this.comparador.compare(valor, noAtualValor) == 1){
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
    public T pesquisar(T valor, Comparator comparador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
        
}
