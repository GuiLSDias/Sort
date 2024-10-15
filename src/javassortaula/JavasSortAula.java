
package javassortaula;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class JavasSortAula {

     public static Pessoa[] geraArrayPessoas() {
        return new Pessoa[]{
            new Pessoa("Carlos", LocalDate.of(1990, 5, 20)),
            new Pessoa("Ana", LocalDate.of(1985, 3, 15)),
            new Pessoa("Ana", LocalDate.of(1983, 3, 15)),
            new Pessoa("Rafael", LocalDate.of(2000, 1, 25)),
            new Pessoa("Bruno", LocalDate.of(1992, 7, 10))
        };
    }

      public static Integer[] geraArrayAleatorio(int size, int min, int max) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void main(String[] args) {
        // int tamanho = 10;//, min = 1, max = 50;
        //Integer[] vetor1 = {34, 8, 64, 51, 32, 21,12,35,69,45};
        int tamanho = 1_000, min = 1, max = 50;
        Integer[] vetor1 = geraArrayAleatorio(tamanho, min, max);
        Integer[] vetor2 = new Integer[tamanho];
        Integer[] vetor3 = new Integer[tamanho];
        Integer[] vetor4 = new Integer[tamanho];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < tamanho; i++) {
            System.out.print("|" + vetor1[i]);
        }
        System.out.println(" ");
        System.out.println("Valor para busca:");
        Integer x = scanner.nextInt();
        Search busca = new Search();

        System.out.println("\nBusca Linear:");
        System.out.println("Posição: " + busca.linearSearch(vetor1, x));
        System.out.println("Comparações: " + busca.getContaComparacoes());
        System.out.println(" ");

        // Cópia dos vetores
        for (int i = 0; i < tamanho; i++) {
            vetor2[i] = vetor1[i];
            vetor3[i] = vetor1[i];
            vetor4[i] = vetor1[i];
        }

        Comparator<Integer> comparatorInteiro = (a, b) -> a.compareTo(b);

        BubbleSort<Integer> bsort = new BubbleSort<>();
        SelectionSort<Integer> ssort = new SelectionSort<>();
        InsertionSort<Integer> isort = new InsertionSort<>();
        ShellSort<Integer> shellSort = new ShellSort<>();

        // Bubble Sort
        long inicio = System.currentTimeMillis();
        bsort.sort(vetor1, comparatorInteiro);
        long tfinal = System.currentTimeMillis();
        //long tfinal = System.nanoTime();
        long tempo = tfinal - inicio;
        System.out.println("Tempo do Bubble Sort: " + tempo + " Comparações: " + bsort.getContaComparacoes());

        // Selection Sort
        inicio = System.currentTimeMillis();
        ssort.sort(vetor2, comparatorInteiro);
        tfinal = System.currentTimeMillis();
        tempo = tfinal - inicio;
        System.out.println("Tempo do Selection Sort: " + tempo + " Comparações: " + ssort.getContaComparacao());

        // Insertion Sort
        inicio = System.currentTimeMillis();
        isort.sort(vetor3, comparatorInteiro);
        tfinal = System.currentTimeMillis();
        tempo = tfinal - inicio;
        System.out.println("Tempo do Insertion Sort: " + tempo + " Comparações: " + isort.getContaComparacoes());

        // ShellSort
        inicio = System.currentTimeMillis();
        shellSort.sort(vetor4, comparatorInteiro);
        tfinal = System.currentTimeMillis();
        tempo = tfinal - inicio;
        System.out.println("Tempo do Shell Sort: " + tempo + " Comparações: " + shellSort.getContaComparacao());
        System.out.println(" ");

        for (int i = 0; i < tamanho; i++) {
            System.out.print("|" + vetor4[i]);
        }
        System.out.println(" ");
        System.out.println("Busca Binaria:");
        System.out.println("Posição: " + busca.binarySearch(vetor1, x));
        System.out.println("Comparações: " + busca.getContaComparacoes());
    }

}
