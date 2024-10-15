package javassortaula;

import java.util.Comparator;

public class ShellSort<T> {
    private long contaComparacao;

    public long getContaComparacao() {
        return contaComparacao;
    }

    public void sort(T[] v, Comparator<T> comparador) {
        int n = v.length;
        contaComparacao = 0;


        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = v[i];
                int j;
                for (j = i; j >= gap && comparador.compare(v[j - gap], temp) > 0; j -= gap) {
                    v[j] = v[j - gap];
                    contaComparacao++;
                }
                v[j] = temp;
            }
        }
    }
}
