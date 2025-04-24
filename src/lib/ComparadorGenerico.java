package app;

import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 * 
 * Essa é comparadora de alunos por nome que será utilizada para criar as árvores
 * nos programas de teste para redigir os relatórios.
 */

public class ComparadorGenerico<T> implements Comparator<T> {
 
    @Override
    public int compare(T v1, T v2) {
        return v1.equals(v2);
    }
    
}
