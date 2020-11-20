import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) throws Exception {
        float lista[] = new float[15];
        Scanner scan = new Scanner(System.in);
        float maior = 0;
        float menor = 0;
        float soma = 0;
        float produto = 1;
        

        for (int i = 0; i < lista.length; i++){
            System.out.println("Digite um numero: ");
            lista[i] = scan.nextFloat();
            if(lista[i] > maior){
                maior = lista[i];
            }
            if(i == 0) {
                menor = lista[i];
            }
            if(lista[i] < menor){
                menor = lista[i];
            }
            if(lista[i] %2 ==0){
                soma += lista[i];
            }
            if(lista[i] %2 !=0){
                produto *= lista[i];
            }
        }
        scan.close();
        System.out.println("Maior numero: " +maior);
        System.out.println("Menor numero: " +menor);
        System.out.println("Soma dos numeros pares: " +soma);
        System.out.println("Produto dos impares: " +produto);
        
    }
}