public class NoArvore {
    int valor;
    int vetor[];
    int pos;
    NoArvore esquerda;
    NoArvore direita;

    public NoArvore() {
        this.valor = 0;
        this.esquerda = null;
        this.direita = null;
        this.vetor = new int[5101];
        this.pos = 0;
        
    }

    public void Imprimi(NoArvore tree) {
        if (tree != null) {
            Imprimi(tree.esquerda);
            System.out.println(tree.valor + "-");
            Imprimi(tree.direita);
        }

    }

    public NoArvore Search(NoArvore tree, int valor) {
        if (tree == null) {
            return null;
        } else if (tree.valor > valor) {
            return (Search(tree.esquerda, valor));
        } else if (tree.valor < valor) {
            return (Search(tree.direita, valor));
        } else
            return (tree);
    }

    public NoArvore InsereRaiz(NoArvore tree, int valor) {
        tree.valor = valor;
        tree.direita = null;
        tree.esquerda = null;
        return (tree);
    }

    public NoArvore Insere(NoArvore tree, int valor) {
        if (tree == null) {
            tree = new NoArvore();
            tree.valor = valor;
            tree.direita = null;
            tree.esquerda = null;
            
        } else if (valor < tree.valor) {
            tree.esquerda = Insere(tree.esquerda, valor);
        } else {
            tree.direita = Insere(tree.direita, valor);
        }
    
        return (tree);
    }

    private NoArvore BalanceiaEsquerda(int array[], int inicio, int fim, NoArvore raiz) {
        int meio = (inicio + fim) / 2;
        if (fim <= inicio || array[meio] == 0) {
            return raiz;
        }
        
        raiz.Insere(raiz, array[meio]);
        BalanceiaEsquerda(array, inicio, meio,raiz);

        return raiz;
    }
    private NoArvore BalanceiaDireita(int array[], int inicio, int fim, NoArvore raiz) {
        int meio = (inicio + fim) / 2;
        if (fim <= inicio || meio == 0) {
            return raiz;
        }
        
        raiz.Insere(raiz, array[meio]);
        BalanceiaDireita(array, meio+1,fim,raiz);

        return raiz;
    }
    
    NoArvore balanceiaArvore(NoArvore raiz) {
        NoArvore raizAux = new NoArvore();
        int vetorAux[];
        vetor = quickSort(vetor, 0, vetor.length - 1);
        vetorAux = vetor;

        InsereRaiz(raizAux, vetor[(vetor.length-1)/2]);
        raizAux = BalanceiaEsquerda(vetor, 0, vetor.length-1, raizAux);
        raizAux = BalanceiaDireita(vetor, 0, vetor.length-1, raizAux);

        this.pos = 0;

        for(int num: vetorAux){
            Insere(raizAux, num);
        }

        return raizAux;
    }

    NoArvore Retira(NoArvore tree, int valor) {
        if (tree == null) {
            System.out.println("Elemento não encontrado..: " + valor);
            return (null);
        } else if (tree.valor > valor) {
            tree.esquerda = Retira(tree.esquerda, valor);
        } else if (tree.valor < valor) {
            tree.direita = Retira(tree.direita, valor);
        } else {

            if ((tree.esquerda == null) && (tree.direita == null)) {
                tree = null;
            } else if (tree.esquerda == null) {
                NoArvore novo = tree;
                tree = tree.direita;
            } else if (tree.direita == null) {
                NoArvore novo = tree;
                tree = tree.esquerda;
            } else {

                NoArvore novo = tree.esquerda;
                while (novo.direita != null) {
                    novo = novo.direita;
                }
                tree.valor = novo.valor;
                novo.valor = valor;
                tree.esquerda = Retira(tree.esquerda, valor);
            }
        }
        return (tree);
    }

    private static int[] quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = quick(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
        return vetor;
    }

    private static int quick(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}
