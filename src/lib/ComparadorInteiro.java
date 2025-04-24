package lib;

import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 * 
 * Essa é comparadora de alunos por matrícula que será utilizada para criar as árvores
 * nos programas de teste para redigir os relatórios.
 */

public class ComparadorInteiro implements Comparator<Integer> {
    /*O nosso comparador utiliza o método compare da classe integer para comparar as matrículas de 2 alunos
    *Eu poderia ter feito um if para vrificar qual matrícula é maior e retornar 1, -1 ou 0...
    */    
    @Override
    public int compare(Integer n1, Integer n2) {
        return Integer.compare(n1, n2);
    }

}
