import java.util.Scanner;

public class index {

public static void main(String[] args) throws Exception {
    
    long tempoInicial = System.currentTimeMillis();

    int numDisco = 0;

    Scanner scan = new Scanner(System.in);
	System.out.println("Digite o número de discos: ");
    numDisco = scan.nextInt();
    
    Hanoi.hanoi(numDisco);
    scan.close();

    long tempoFinal = System.currentTimeMillis();

    System.out.println((tempoFinal - tempoInicial)/1000+ " segundos para executar o algoritmo com "+ numDisco+ " discos");
}
}
