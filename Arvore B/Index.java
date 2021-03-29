import java.util.Random;

public class Principal3 {
    public static void main(String[] args) {
        ArvoreB raiz = new ArvoreB(4);
        int array[] = new int[10];

        long tempoInicial = System.currentTimeMillis();

        array = buscaPrimos();
        populaArvore(raiz);
        verifica(array, raiz);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("O tempo gasto foi de " + (tempoFinal - tempoInicial) + " ms");
    }

    public static int[] buscaPrimos() {
        int array[] = new int[10];
        int qtd = 0;

        for (int i = 1; i < 100; i++) {

            boolean isPrimo = true;

            for (int j = 2; j < i; j++) {

                if (i % j == 0) {
                    isPrimo = false;
                    break;
                }
            }

            if (isPrimo && qtd < 10) {
                array[qtd] = i;
                qtd++;
            }
        }
        return array;
    }

    public static ArvoreB populaArvore(ArvoreB raiz) {
        Random aleatorio = new Random();
        int resultado = 0;
        int qtd = 0;

        while (raiz.getnElementos() != 5000) {
            resultado = aleatorio.nextInt(9999);
            raiz.insere(resultado);
            qtd++;
        }
        return raiz;
    }

    public static void verifica(int array[], ArvoreB raiz) {
        Random aleatorio = new Random();

        searchPrimo(array, raiz);
        multi(raiz);

        int qtd = 0;
        int resultado = 0;
        while (qtd < 100) {
            resultado = aleatorio.nextInt(9999) + 1;
            raiz.insere(resultado);
            qtd++;
        }

        searchPrimo(array, raiz);
        multi(raiz);

    }

    public static void searchPrimo(int array[], ArvoreB raiz) {
        No arvore = new No(4);
        No noRaiz = raiz.getRaiz();

        for (int i = 0; i < array.length; i++) {
            raiz.BuscaChave(noRaiz, array[i]);
            if (arvore == null) {
                System.out.println("O numero primo " + array[i] + " não esta na arvore!");
            } else {
                System.out.println("O numero primo " + array[i] + " esta na arvore!");
                raiz.Remove(i);

            }
        }
    }

    public static void multi(ArvoreB raiz) {
        No noRaiz = raiz.getRaiz();
        No no = new No(4);

        System.out.println("Multiplos de 5: ");

        for (int i = 0; i < 9999; i += 5) {

            no = raiz.BuscaChave(noRaiz, i);
            if(no == null){
                System.out.println(i+" não esta na arvore B");
            }else{
                System.out.println(i+" esta na arvore B");
                //raiz.Remove(i);
            }
        }

    }
}
