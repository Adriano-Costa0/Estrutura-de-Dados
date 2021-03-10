import java.util.Random;

public class mainArvore {
    public static void main(String[] args) {
        NoArvore raiz = new NoArvore();
        int array[] = new int[10];
        int arrayArvore[] = new int[5101];

        arrayArvore = populaArvore(raiz, 5000);

        array =  buscaPrimos();
        verifica(array,arrayArvore, raiz);

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
        
    public static int [] populaArvore(NoArvore raiz, int valor){
        int array[] = new int[valor];
        Random aleatorio = new Random();
        
        int qtd = 0;
        int resultado = 0;
        while(qtd < valor) {
                resultado = aleatorio.nextInt(9999);
                raiz.Insere(raiz, resultado );
                array[qtd] = resultado;
                qtd++;
                raiz.vetor[raiz.pos] = resultado; 
                raiz.pos++;
        }
        return array;
    }
   
    public static void verifica(int array[], int arrayArvore[], NoArvore raiz){
        Random aleatorio = new Random();

        searchPrimo(array, raiz);
        multi(arrayArvore, raiz);
        
        
        int qtd = 0;
        int resultado = 0;
        while(qtd < 100) {
                resultado = aleatorio.nextInt(9999);
                raiz.Insere(raiz, resultado );
                qtd++;
                raiz.vetor[raiz.pos] = resultado; 
                raiz.pos++;
        }

        searchPrimo(array, raiz);
        multi(arrayArvore, raiz);

        

       
    }

    public static void searchPrimo(int array[], NoArvore raiz){
        NoArvore arvore = new NoArvore();
        raiz = raiz.balanceiaArvore(raiz);

        for (int i = 0; i < array.length; i++){
            arvore = raiz.Search(raiz, array[i]);
            if(arvore == null){
                System.out.println("O numero primo "+ array[i]+ " não esta na arvore!");
            }
            else {
                System.out.println("O numero primo "+ array[i]+ " esta na arvore!");
                raiz.Retira(raiz, array[i]);
            }
        }
    }

    public static void multi(int arrayArvore[], NoArvore raiz){

        raiz = raiz.balanceiaArvore(raiz);
        System.out.println("Multiplos de 5: ");
        for(int num: arrayArvore){
            if(num%5 == 0){
                System.out.println("[Multiplo de 5] -> "+num);
                raiz.Retira(raiz, num);
            }
            
        }
    }
}


