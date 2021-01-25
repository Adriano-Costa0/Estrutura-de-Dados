import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Exercicio {
    static int numMovimentos;

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> lista = new ArrayList<Integer>();
        String listaString[] = {};
        String linha = "";

        // File arquivo = new File("C:\\Users\\Adriano Costa\\Downloads\\lista de dados 1.txt");
        File arquivo = new File("C:\\Users\\Adriano Costa\\Downloads\\lista de dados 4.txt");
        // File arquivo = new File("C:\\Users\\Adriano Costa\\Downloads\\lista de dados 3.txt");
        File path = new File("C:\\Users\\Adriano Costa\\Downloads\\lista  de respostas.txt");

        

        FileReader arq = new FileReader(arquivo);
        BufferedReader buffRead = new BufferedReader(arq);

        while (true) {
            if (linha != null) {
                System.out.println(linha);
                listaString = linha.split(", ");
            } else
                break;
            linha = buffRead.readLine();

        }
        buffRead.close();

        for (String num : listaString) {
            lista.add(Integer.parseInt(num));

        }
        System.out.println(lista.toString());

        int vetor[] = lista.stream().mapToInt(i -> i).toArray();

        long tempoInicial = System.currentTimeMillis();
        //vetor = insertionSort(vetor);
        // vetor = selectionSort(vetor);
        // vetor = bubbleSort(vetor);
         vetor = comboSort(vetor);
        long tempoFinal = System.currentTimeMillis();

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
        buffWrite.append("Nome: Adriano Costa Araujo Morais\n");
        buffWrite.append("Tempo de execução:" + (tempoFinal - tempoInicial) + " ms\n");
        buffWrite.append("Numero de Movimentos: " + numMovimentos + " movimentos\n");
        buffWrite.append("Vetor ordenado = ");
        for (int x : vetor) {
            buffWrite.append(x + ", ");
        }
        buffWrite.append("\n \n");
        buffWrite.close();

    }

    public static int[] insertionSort(int[] vetor) {
        int j;
        int key;
        int i;
        numMovimentos = 0;

        for (j = 1; j < vetor.length; j++) {
            numMovimentos++;
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
                vetor[i + 1] = vetor[i];
                numMovimentos++;
            }
            vetor[i + 1] = key;
            numMovimentos++;
        }
        return vetor;
    }

    public static int[] selectionSort(int[] array) {
        numMovimentos = 0;
        
        for (int fixo = 0; fixo < array.length - 1; fixo++) {
            int menor = fixo;
            numMovimentos++;

            for (int i = menor + 1; i < array.length; i++) {
                if (array[i] < array[menor]) {
                    menor = i;
                    numMovimentos++;
                }
            }
            if (menor != fixo) {
                int t = array[fixo];
                array[fixo] = array[menor];
                array[menor] = t;
                numMovimentos++;
            }
        }
        return array;
    }

    public static int[] bubbleSort(int vetor[]) {
        numMovimentos = 0;
        boolean troca = true;
        int aux;

        while (troca) {
            troca = false;
            numMovimentos++;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                    numMovimentos++;
                }
            }
        }
        return vetor;
    }

    public static int[] comboSort(int vetor[]) {
        numMovimentos = 0;

        if (vetor.length <= 1) {
            numMovimentos++;
            return vetor;
        }

        int intervalo = (int) (vetor.length / 1.3);
        int indice = 0;

        while (intervalo > 0 && indice != vetor.length - 1) {
            indice = 0;
            numMovimentos++;
            while ((indice + intervalo) < vetor.length) {
                if (vetor[indice] > vetor[indice + intervalo]) {
                    int aux = vetor[indice];
                    vetor[indice] = vetor[indice + intervalo];
                    vetor[indice + intervalo] = aux;
                    numMovimentos++;
                }
                indice++;
                numMovimentos++;
            }
            intervalo = (int) (intervalo / 1.3);
            numMovimentos++;
        }
        return vetor;
    }
}
