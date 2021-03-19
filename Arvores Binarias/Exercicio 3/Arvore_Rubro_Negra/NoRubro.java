public class NoRubro {
    int valor;
    int cor;
    int pos;
    int vetor[];
    NoRubro esquerda;
    NoRubro direita;

    public NoRubro(){
        this.valor = 0;
        this.cor = 1;
        this.esquerda = null;
        this.direita = null;
        this.pos = 0;
        this.vetor = new int[5100];
    }

    public void imprimir(NoRubro No) {
        if (No != null) {
            imprimir(No.esquerda);
            System.out.println(No.valor+"| "+No.cor);
            imprimir(No.direita);
        }

    }

    public NoRubro inserir(NoRubro No, int valor){
        if(No == null){
            NoRubro newNo = new NoRubro();
            newNo.valor = valor;
            newNo.cor = 1;
            newNo.esquerda = null;
            newNo.direita = null;
            return newNo;
        }
        else if(valor == No.valor){
            return No;
        }
        else{
            if(valor < No.valor){
                No.esquerda = inserir(No.esquerda, valor);
            }
            else{
                No.direita = inserir(No.direita, valor);
            }
        }

        if(getCor(No.direita) == 1 && getCor(No.esquerda) == 0){
            No = rotacaoEsquerda(No);
        }
        else if(getCor(No.esquerda) == 1 && getCor(No.esquerda.esquerda) == 1){
            No = rotacaoDireita(No);
        }
        else if(getCor(No.esquerda) == 1 && getCor(No.direita) == 1){
            trocarCor(No);
        }
        return No;
    }

    public NoRubro remover(NoRubro No, int valor){
        if(valor < No.valor){
            if(getCor(No.esquerda) == 0 && getCor(No.esquerda.esquerda) == 0){
                No = vermelhoParaEsquerda(No);
            }
        No.esquerda = remover(No.esquerda, valor);
        }
        else{
            if(getCor(No.esquerda) == 0){
                No = rotacaoDireita(No);
            }
            else if(valor == No.valor && No.direita == null){
                return null;
            }

            else if(getCor(No.direita) == 0 && getCor(No.direita.esquerda) == 0){
                No = vermelhoParaDireita(No);
            } 
            else if(valor == No.valor) {
                NoRubro aux = buscaMenor(No.direita);
                No.valor = aux.valor;
                No.direita = removeMenor(No.direita);
            }else{
                No.direita = remover(No.direita, valor);
            }
        }

        return balancear(No);
        
    }

    public NoRubro removeMenor(NoRubro No){
        if(No.esquerda == null){
            return null;
        }
        else if(getCor(No.esquerda) == 0 && getCor(No.esquerda.esquerda) == 0){
            No = vermelhoParaEsquerda(No);
        }

        No.esquerda = removeMenor(No.esquerda);

        return balancear(No);
    }

    public NoRubro buscaMenor(NoRubro No){
        NoRubro NoATual = No;
        NoRubro NoAux = No.esquerda;

        while(NoAux != null){
            NoATual = NoAux;
            NoAux = NoAux.esquerda;
        }
        return NoATual;
    }

    
    public NoRubro balancear(NoRubro No){
        if(getCor(No.direita) == 1){
            No = rotacaoEsquerda(No);
        }
        else if(No.esquerda == null && getCor(No.direita) == 1 && getCor(No.esquerda.esquerda) == 1){
            No = rotacaoDireita(No);
        }
        else if(getCor(No.esquerda) == 1 && getCor(No.direita) == 1){
            trocarCor(No);
        }
        return No;
    }

    public NoRubro rotacaoEsquerda(NoRubro No){
        NoRubro aux = No.direita;
        No.direita = aux.esquerda;
        aux.esquerda = No;
        aux.cor = No.cor;
        No.cor = 1; // equivale a cor vermelha

        return aux;
    }

    public NoRubro rotacaoDireita(NoRubro No){
        NoRubro aux = No.esquerda;
        No.esquerda = aux.direita;
        aux.direita = No;
        aux.cor = No.cor;
        No.cor = 1;

        return aux;
    }

    public NoRubro vermelhoParaEsquerda(NoRubro No){
        trocarCor(No);
        if(getCor(No.direita.esquerda) == 1){
            No.direita = rotacaoDireita(No.direita);
            No = rotacaoEsquerda(No);
            trocarCor(No);
        }
        return No;
    }

    public NoRubro vermelhoParaDireita(NoRubro No){
        trocarCor(No);
        if(getCor(No.esquerda.esquerda ) == 1){
            No = rotacaoDireita(No);
            trocarCor(No);
        }
        return No;
    }

    public NoRubro buscar(NoRubro No, int valor) {
        if (No == null) {
            return null;
        } else if (No.valor > valor) {
            return (buscar(No.esquerda, valor));
        } else if (No.valor < valor) {
            return (buscar(No.direita, valor));
        } else
            return (No);
    }

    public int getCor(NoRubro No){
        if(No == null){
            return 0;
        }else{
            return No.cor;
        }
    }

    private void trocarCor(NoRubro No){
        No.cor = corInversa(No);
        if(No.esquerda != null){
            No.esquerda.cor = corInversa(No.esquerda);
        }
        else if(No.direita != null){
            No.direita.cor = corInversa(No.direita);
        }
    }

    private int corInversa(NoRubro No){
        if(No.cor == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
