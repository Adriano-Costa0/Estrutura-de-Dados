import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) throws Exception {
        int lista[] = new int[10];
        Scanner scan = new Scanner(System.in);
        float soma = 0;
        float produto = 1;
        String decrescente = "";
        

        

        for (int i = 0; i < lista.length; i++){
            System.out.println("Digite um numero: ");
            lista[i] = scan.nextInt();
        } 
        scan.close();

        for(int i = 0; i < lista.length; i++){
            int key = lista[i];
            int j = i-1;
            while((j > -1) && (lista[j] > key)){
                lista[j+1] = lista[j];
                j--;
            }
            lista[j+1] = key;
        }

        System.out.println("Vetor ordem crescente: ");
        for (int i = 0; i < lista.length; i++){

            decrescente = lista[i]+", "+decrescente;
            if(lista[i] %2 ==0){
                soma += lista[i];
            }
            if(lista[i] %2 !=0){
                produto *= lista[i];
            }

            System.out.print(lista[i]+", ");
        }

        System.out.println("\nVetor ordem decrescente: \n"+decrescente);

       

        System.out.println("Soma dos numeros pares: " +soma);
        System.out.println("Produto dos impares: " +produto);
   
        
    }
}