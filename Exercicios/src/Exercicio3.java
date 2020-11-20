import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) throws Exception { 
        String alunos[]= new String[5];
    float notas[][] = new float[2][5];
    float media = 0;

    Scanner scan = new Scanner(System.in);
        String result = "";
        for (int i = 0; i < alunos.length; i++){
            System.out.println("Digite um nome");
            alunos[i] = scan.nextLine();
        }

        for (int i = 0; i<1; i++){
            
            for (int j = 0; j<notas[i].length; j++){
                System.out.println("Qual o nota da prova 1 do aluno "+alunos[j]);
                notas[0][j] = scan.nextFloat(); 
                System.out.println("Qual o nota da prova 2 do aluno "+alunos[j]);
                notas[1][j] = scan.nextFloat();
                media = (notas[0][j] + notas[1][j])/2;

                if(media > 6){
                    result+= "Aluno |Prova 1 | Prova 2 | Media | Situaçao | = " + alunos[j]+" | "+ notas[0][j] +" | "+ notas[1][j] +" | "+ media + " | "+"Aprovado\n";
                }
                else{
                    result+= "Aluno |Prova 1 | Prova 2 | Media | Situaçao | = " + alunos[j]+" | "+ notas[0][j] +" | "+ notas[1][j] +" | "+ media + " | "+"Reprovado\n";
                }
            }
            System.out.println(result);

    }
    scan.close();
}
}