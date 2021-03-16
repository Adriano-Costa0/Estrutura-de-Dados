public class NoAVL {
    int valor;
    int altura;
    int pos;
    int vetor[] ;
    NoAVL esquerda;
    NoAVL direita;

    public NoAVL(){
        this.valor =0;
        this.altura = 0;
        this.esquerda = null;
        this.direita = null;
        this.pos = 0;
        this.vetor = new int[5100];


    }

    public void imprimir(NoAVL No) {
        if (No != null) {
            imprimir(No.esquerda);
            System.out.println(No.valor);
            imprimir(No.direita);
        }

    }

     NoAVL inserir(NoAVL raiz, int valor) {
        if(raiz == null){
            raiz = new NoAVL();
            raiz.valor = valor;
            raiz.direita = null;
            raiz.esquerda = null;
            raiz.altura = 0;
        }
        else if(valor < raiz.valor){
            raiz.esquerda = inserir(raiz.esquerda, valor);
            if(altura(raiz.esquerda) - altura(raiz.direita) == 2){
                if(valor < raiz.esquerda.valor){
                    raiz = direita(raiz);
                }
                else{
                    raiz = esquerdaDireita(raiz);
                }
            }
        }
        else {
            if(valor > raiz.valor) {
                raiz.direita = inserir(raiz.direita, valor);
                if(altura(raiz.direita) - altura(raiz.esquerda) == 2){
                    if(valor > raiz.direita.valor){
                        raiz = esquerda(raiz);
                    }
                    else{
                        raiz = direitaEsquerda(raiz);
                    }
                }
            }
        }

        raiz.altura = max(altura(raiz.esquerda), altura(raiz.direita))+1;
        return raiz;
    }

    public int removeAvl(NoAVL No, int valor){
        int result = 1;
        if (No == null) {
            System.out.println("Elemento não encontrado..: " + valor);
            return (0);
        }
        else if (valor < No.valor) {
             result = removeAvl(No.esquerda, valor);
            if(result == 1 ){
                if(altura(No.esquerda) - altura(No.direita) >= 2){
                    if(No.esquerda.direita.altura <= No.direita.direita.altura){
                        esquerda(No);
                    }
                    else{
                        direitaEsquerda(No);
                    }
                }
            }

        }

        else if(valor > No.valor){
                 result = removeAvl(No.direita, valor);
                if(result == 1){
                    if(altura(No.esquerda) - altura(No.direita) >= 2){
                        if(No.esquerda.direita.altura <= No.esquerda.esquerda.altura){
                            direita(No);
                        }
                        else{
                            esquerdaDireita(No);
                        }
                    }
                }
            }


            else if(valor == No.valor){
                if(No.esquerda == null || No.direita == null){
                    if(No.esquerda == null){
                        No = No.esquerda;
                    }
                    else{
                        No = No.direita;
                    }
                }
                else{
                    NoAVL menor = buscaMenor(No.direita);
                    No.valor = menor.valor;
                    removeAvl(No.direita, No.valor);
                    if(altura(No.esquerda) - altura(No.direita) >= 2){
                        if(No.esquerda.direita.altura <= No.esquerda.esquerda.altura){
                            direita(No);
                        }
                        else{
                            esquerdaDireita(No);
                        }
                    }
                }
                return 1;
                
            }
            No.altura = max(altura(No.esquerda), altura(No.direita))+1;
            return result;
    }

    public NoAVL buscaMenor(NoAVL No){
        NoAVL atual = No;
        NoAVL atualEsq = No.esquerda;

        while(atualEsq != null){
            atual = atualEsq;
            atualEsq = atualEsq.esquerda;
        }

        return atual;
    }

    public NoAVL buscar(NoAVL No, int valor) {
        if (No == null) {
            return null;
        } else if (No.valor > valor) {
            return (buscar(No.esquerda, valor));
        } else if (No.valor < valor) {
            return (buscar(No.direita, valor));
        } else
            return (No);
    }


    public NoAVL direita(NoAVL raiz){
        NoAVL aux = new NoAVL();
        aux = raiz.esquerda;

        raiz.esquerda = aux.direita;

        aux.direita = raiz;

        raiz.altura = max(altura(raiz.direita), altura(raiz.esquerda))+1;
        aux.altura = max(altura(aux.esquerda), raiz.altura )+1;

        return aux;

    }

    public NoAVL esquerda(NoAVL raiz){
        NoAVL aux = new NoAVL();
        aux = raiz.direita;

        raiz.direita = aux.esquerda;

        aux.esquerda = raiz;

        raiz.altura = max(altura(raiz.direita), altura(raiz.esquerda))+1;
        aux.altura = max(altura(aux.direita), raiz.altura )+1;

        return aux;

    }

    public NoAVL esquerdaDireita(NoAVL raiz) {
        raiz.esquerda = esquerda(raiz.esquerda);
        return direita(raiz);
    }
    
    public NoAVL direitaEsquerda(NoAVL raiz) {
        raiz.direita = direita(raiz.direita);
        return esquerda(raiz);
    }


    public int max(int a, int b){
        if(a > b){
            return a;
        }
        return b;
    }

    public int altura(NoAVL raiz) {
        if(raiz == null){
            return -1;
        }
        return raiz.altura;

    }
}