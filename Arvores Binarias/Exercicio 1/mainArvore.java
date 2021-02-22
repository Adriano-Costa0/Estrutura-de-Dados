public class mainArvore {
    public static void main(String[] args) {

        int qtd = 0;
        int i = 2;
        NoArvore raiz = new NoArvore();
        NoArvore arvore = new NoArvore();

        while (qtd < 500) {
            if (verificaPrimo(i)) {
                qtd++;
            }
            if (qtd == 500) {
                raiz = arvore.InsereRaiz(raiz, i);
                break;
            }
            i++;
        }

        populaArvore(raiz);
        removeMenor(raiz);
        raiz.Imprimi_Cres(raiz);
        

    }

    public static boolean verificaPrimo(int valor) {
        for (int j = 2; j < valor; j++) {
            if (valor % j == 0)
                return false;
        }
        return true;
    }

    public static void populaArvore(NoArvore raiz){
        int qtd = 0;
        int i = 2;
        while(qtd < 1000) {
            if(verificaPrimo(i)){
                raiz.Insere(raiz, i);
                qtd++;
            
        }
        i++;
        
    }
}

    public static void removeMenor(NoArvore raiz){
        int qtd = 0;
        int indice = 2;
        int i = 2;
        NoArvore arvore = new NoArvore();

        while(qtd < 1000) {
            if(verificaPrimo(i)){
                if(i == indice || i >= indice){
                    arvore.Retira(raiz,i);
                    indice += 100;
                }
                qtd++;
            }
            if(qtd == 1000){
                break;
            }
            i++;
                
            }
        }
    }

