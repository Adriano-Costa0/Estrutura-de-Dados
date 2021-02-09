import java.io.*;
import java.util.*;

public class Exercicio4 {

    public static void main(String[] args) throws IOException {

        int vetor[] = { 56, 63, 68, 756, 852, 3, 45, 1, 25, 89, 12, 9, 10 };
        int num = vetor.length;

        long tempoInicial = System.currentTimeMillis();

        //radixSort(vetor, num);
        // gnomeSort(vetor, num);
         countingSort(vetor);

        long tempoFinal = System.currentTimeMillis();

        print(vetor, num);
        System.out.println("Tempo: " + (tempoFinal - tempoInicial) + " ms");

    }

    public static void radixSort(int array[], int valor) {

        int maior = getMaior(array, valor);

        for (int exp = 1; maior / exp > 0; exp *= 10)
            count(array, valor, exp);
    }

    public static int getMaior(int array[], int valor) {
        int maior = array[0];
        for (int i = 1; i < valor; i++)
            if (array[i] > maior)
                maior = array[i];
        return maior;
    }

    public static void count(int array[], int valor, int exp) {
        int arrayAux[] = new int[valor];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < valor; i++)
            count[(array[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = valor - 1; i >= 0; i--) {
            arrayAux[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < valor; i++)
            array[i] = arrayAux[i];
    }

    public static void gnomeSort(int array[], int valor) {
        int index = 0;

        while (index < valor) {
            if (index == 0)
                index++;
            if (array[index] >= array[index - 1])
                index++;
            else {
                int temp = 0;
                temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
        return;
    }

    public static void countingSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    public static void print(int array[], int num) {
        for (int i = 0; i < num; i++)
            System.out.print(array[i] + " ");
    }

}
