package javassortaula;

import java.util.Comparator;

public class ShellSort<T> {
    private long contaComparacao;

    public long getContaComparacao() {
        return contaComparacao;
    }

    public void sort(T[] v, Comparator<T> comparador) {
        int n = v.length;
        contaComparacao = 0; // Zera o contador de comparações

        // Gap sequence (reduz pela metade em cada iteração)
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Inserção por intervalos de "gap"
            for (int i = gap; i < n; i++) {
                // Armazena o elemento a ser posicionado
                T temp = v[i];
                int j;

                // Compara elementos com base no gap
                for (j = i; j >= gap && comparador.compare(v[j - gap], temp) > 0; j -= gap) {
                    v[j] = v[j - gap]; // Move o elemento para a frente se maior
                    contaComparacao++;  // Incrementa o contador de comparações
                }

                v[j] = temp; // Coloca o elemento na posição correta
            }
        }
    }
}
