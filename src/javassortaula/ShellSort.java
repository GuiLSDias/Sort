package javassortaula;

import java.util.Comparator;

public class ShellSort<T> {
    private long contaComparacao;

    public long getContaComparacao() {
        return contaComparacao;
    }

   public void sort(T[] array, Comparator<T> comparator) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
           System.out.println("\nGap atual: " + gap);
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && comparator.compare(array[j - gap], temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                    contaComparacao++;
                }
                array[j] = temp;
            }
            System.out.print("Estado do array após gap " + gap + ": ");
            for (T item : array) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    /*public void sort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        contaComparacao = 0;

        int gap = 1;
        while (gap < n / 3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            System.out.println("\nGap atual: " + gap);

            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && comparator.compare(array[j - gap], temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                    contaComparacao++;
                }
                array[j] = temp;
            }

            System.out.print("Estado do array após gap " + gap + ": ");
            for (T item : array) {
                System.out.print(item + " ");
            }
            System.out.println();
            gap = (gap - 1) / 3;
        }
    }*/

}
