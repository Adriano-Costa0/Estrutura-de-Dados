import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) throws Exception {
        
        String nomes[] = new String[5];
        Scanner scan = new Scanner(System.in);
        String nomeSearch = "";
        for (int i = 0; i < nomes.length; i++){
            System.out.println("Digite um nome");
            nomes[i] = scan.nextLine().toUpperCase();
        }
        System.out.println("Qual nome quer saber ?\n");
        nomeSearch = scan.nextLine().toUpperCase();

        scan.close();
        for (int i =0; i<5; i++){
            if(nomeSearch.equals(nomes[i].toUpperCase())){
                System.out.println("O nome esta na posiçao: "+ i);
                return;
            }
                
        }
        System.out.println("O nome não foi encontrado");

        


    }
}