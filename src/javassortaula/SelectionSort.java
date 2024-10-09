
package javassortaula;
import java.util.Comparator;
public class SelectionSort<T> {
    private long contaComparacao;

    public long getContaComparacao() {
        return contaComparacao;
    }

    private int indiceMenorValor(T[] v, int posicao, Comparator<T> comparador){
        int indiceMenor = posicao;
        for(int i=posicao+1;i<v.length;i++) {
            this.contaComparacao++;
            if (comparador.compare(v[i], v[indiceMenor]) < 0)
                indiceMenor = i;
        } return indiceMenor;
    }
    //--------------------
    void troca(T[] v, int i, int j){
        T temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
    //--------------
    public void sort(T[] v, Comparator<T> comparador){
        int n= v.length;
        this.contaComparacao = 0;
        for(int i=0;i<n-1;i++){ // for da fase
            int indiceMenor = indiceMenorValor(v, i, 
                              comparador);
            troca(v, i, indiceMenor);
        }
            
    }
    
}
