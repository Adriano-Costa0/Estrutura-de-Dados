import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        NoRubro raiz = new NoRubro();
        int array[] = new int[10];

        long tempoInicial = System.currentTimeMillis();
        
        array = buscaPrimos();
        raiz =  populaArvore(raiz);
        verifica(array, raiz);
        //raiz.imprimir(raiz);
       
        long tempoFinal = System.currentTimeMillis();

        System.out.println("O tempo gasto foi de "+(tempoFinal - tempoInicial)+" ms");
    }
    public static int [] buscaPrimos(){
        int array[] = new int[10];
        int qtd = 0;

        for(int i=1; i < 100; i++){

            boolean isPrimo = true;
        
            for(int j=2; j < i ; j++){
            
            if(i % j == 0){
            isPrimo = false;
            break;
            }
            }
            
            if(isPrimo && qtd <10){
                array[qtd] = i;
                qtd++;
            }
            }
        return array;
    }
        
    public static NoRubro populaArvore(NoRubro raiz){
        Random aleatorio = new Random();
        int vetor[] = new int[5100];
        int qtd = 0;
        int resultado = 0;
        while(qtd < 5000) {
                resultado = aleatorio.nextInt(9999)+1;
                raiz = raiz.inserir(raiz , resultado );
                vetor[qtd] = resultado;
                qtd++;
              
        }
        raiz.vetor = vetor;
        raiz.pos = qtd;
        return raiz;
    }
   
    public static void verifica(int array[], NoRubro raiz){
        Random aleatorio = new Random();

        
        searchPrimo(array, raiz);
        multi(raiz);
        
        
        
        int qtd = 0;
        int resultado = 0;
        while(qtd < 100) {
                resultado = aleatorio.nextInt(9999)+1;
                raiz.inserir(raiz, resultado );
                raiz.vetor[raiz.pos] = resultado;
                raiz.pos++;
                qtd++;
        }
        

        searchPrimo( array, raiz);
        multi(raiz);

        

       
    }

    public static void searchPrimo(int array[], NoRubro raiz){
        NoRubro arvore = new NoRubro();
    
        for (int i = 0; i < array.length; i++){
            arvore = raiz.buscar(raiz, array[i]);
            if(arvore == null){
                System.out.println("O numero primo "+ array[i]+ " não esta na arvore!");
            }
            else {
                System.out.println("O numero primo "+ array[i]+ " esta na arvore!");
                
            }
        }
    }

    public static void multi( NoRubro raiz){
        int array[] = raiz.vetor;
        System.out.println("Multiplos de 5: ");
        for(int num: array){
            if(num%5 == 0){
                System.out.println("[Multiplo de 5] -> "+num);
               
            }
            
        }
    }
}
