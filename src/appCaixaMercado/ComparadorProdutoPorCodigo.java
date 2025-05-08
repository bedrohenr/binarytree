package appCaixaMercado;

import java.util.Comparator;

public class ComparadorProdutoPorCodigo implements Comparator<Produto> {

    @Override
    public int compare(Produto produto1, Produto produto2) {
        
        return Integer.compare(produto1.getCodigo(), produto2.getCodigo());
    }
    
}
