import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Exercicio3 {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        String listaString[] = {};
        String linha = "";

        File arquivo = new File("C:\\Users\\Adriano Costa\\Downloads\\lista de dados 3.txt");
        File path = new File("C:\\Users\\Adriano Costa\\Downloads\\lista  de respostas.txt");

        try {
            FileReader reader = new FileReader(arquivo);
            BufferedReader read = new BufferedReader(reader);

            while (true) {
                if (linha != null) {
                    listaString = linha.split(", ");
                } else
                    break;
                linha = read.readLine();
            }
            read.close();

            for (String value : listaString) {
                lista.add(Integer.parseInt(value));

            }

            int vetor[] = lista.stream().mapToInt(i -> i).toArray(); // converte um ArrayList para um array

            long tempoInicial = System.currentTimeMillis();

            vetor = heapSort(vetor);

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
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
        }

    }

    public static int[] heapSort(int vetor[]) {

        int size = vetor.length;

        for (int i = size / 2 - 1; i >= 0; i--)
            heap(vetor, size, i);

        for (int i = size - 1; i > 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            heap(vetor, i, 0);
        }
        return vetor;
    }

    public static void heap(int vetor[], int size, int i) {
        int maior = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && vetor[l] > vetor[maior])
            maior = l;

        if (r < size && vetor[r] > vetor[maior])
            maior = r;

        if (maior != i) {
            int swap = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = swap;

            heap(vetor, size, maior);
        }
    }
}
