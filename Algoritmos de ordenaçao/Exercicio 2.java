import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Exercicio2 {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        String listaString[] = {};
        String linha = "";

        File arquivo = new File("C:\\Users\\Adriano Costa\\Downloads\\lista de dados 3.txt");
        File path = new File("C:\\Users\\Adriano Costa\\Downloads\\lista  de respostas.txt");

        BufferedReader buffRead = new BufferedReader(new FileReader(arquivo));

        while (true) {
            if (linha != null) {
                listaString = linha.split(", ");
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();

        for (String value : listaString) {
            lista.add(Integer.parseInt(value));

        }

        int vetor[] = lista.stream().mapToInt(i -> i).toArray(); // converte um ArrayList para um array

        long tempoInicial = System.currentTimeMillis();

        //vetor = quickSort(vetor, 0, vetor.length-1);
        //vetor = mergeSort(vetor, 0, vetor.length-1);
        //vetor = shellSort(vetor);

        long tempoFinal = System.currentTimeMillis();

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        buffWrite.append("Nome: Adriano Costa Araujo Morais\n");
        buffWrite.append("Tempo de execução:" + (tempoFinal - tempoInicial) + " ms\n");
        buffWrite.append("Vetor ordenado = ");
        for (int x : vetor) {
            buffWrite.append(x + ", ");
        }
        buffWrite.append("\n \n");
        buffWrite.close();

    }

    public static int [] quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = quick(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
        return vetor;
    }

    private static int quick(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    public static int [] mergeSort(int[] vetor, int inicio, int fim) {
        if (fim <= inicio)
            return vetor;

        int meio = (inicio + fim) / 2;
        mergeSort(vetor, inicio, meio);
        mergeSort(vetor, meio + 1, fim);
        merge(vetor, inicio, meio, fim);

        return vetor;
    }

    public static void merge(int[] vetor, int inicio, int meio, int fim) {

        int leftArray[] = new int[meio - inicio + 1];
        int rightArray[] = new int[fim - meio];

        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = vetor[inicio + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = vetor[meio + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = inicio; i < fim + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    vetor[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    vetor[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                vetor[i] = leftArray[leftIndex];
                leftIndex++;

            } else if (rightIndex < rightArray.length) {
                vetor[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static int [] shellSort(int[] vetor) {
        int i, j, temp, size = vetor.length;

        int incremento = 1;
        while (incremento < size) {
            incremento = 3 * incremento + 1;
        }

        while (incremento > 1) {
            incremento /= 3;

            for (i = incremento; i < size; i++) {
                temp = vetor[i];
                j = i - incremento;
                while (j >= 0 && temp < vetor[j]) {
                    vetor[j + incremento] = vetor[j];
                    j -= incremento;
                }
                vetor[j + incremento] = temp;
            }
        }
        return vetor;
    }
}