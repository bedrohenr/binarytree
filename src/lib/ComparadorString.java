package lib;

import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 * 
 * Essa é comparadora de alunos por nome que será utilizada para criar as árvores
 * nos programas de teste para redigir os relatórios.
 */

public class ComparadorString implements Comparator<String> {
 
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
    
}
