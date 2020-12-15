public class ListaLigada {

  Celula Primeira;
  Celula ultima;
  int TotaldeElementos = 0;

  void AdicionaNoComeco(Object elemento) {
    Celula nova = new Celula(this.Primeira, elemento);
    this.Primeira = nova;
    if (this.TotaldeElementos == 0) {
      this.ultima = this.Primeira;
    }
    this.TotaldeElementos++;
  }

  void adiciona(Object elemento) {
    if (this.TotaldeElementos == 0) {
      this.AdicionaNoComeco(elemento);
    } else {
      Celula nova = new Celula(elemento);
      this.ultima.setProxima(nova);
      this.ultima = nova;
      this.TotaldeElementos++;
    }
  }

  boolean PosicaoOcupada(int pos) {
    return ((pos >= 0) && (pos < this.TotaldeElementos));
  }

  Celula PegaCelula(int pos) {
    if (!this.PosicaoOcupada(pos)) {
      throw new IllegalArgumentException("Posicao nao Existe");
    } else {
      Celula atual = this.Primeira;
      for (int i = 0; i < pos; i++) {
        atual = atual.getProxima();
      }
      return (atual);
    }

  }

  void adiciona(int pos, Object elemento) {
    if (pos == 0) {
      this.AdicionaNoComeco(elemento);
    } 
    else if (pos == this.TotaldeElementos) {
        this.adiciona(elemento);
    } else {
        Celula anterior = this.PegaCelula(pos - 1);
        Celula Nova = new Celula(anterior.getProxima(), elemento);
        anterior.setProxima(Nova);
        this.TotaldeElementos++;
    }
  }

  Object pega(int posicao) {
    return (this.PegaCelula(posicao).getElemento());
  }

  void removeDoComeco() {
    if (!this.PosicaoOcupada(0)) {
      throw new IllegalArgumentException("Posição não Existe");
    } else {
      this.Primeira = this.Primeira.getProxima();
      this.TotaldeElementos--;
      if (this.TotaldeElementos == 0) {
        this.ultima = null;
      }
    }
  }

  boolean Contem(Object elemento) {
    Celula atual = this.Primeira;
    while (atual != null) {
      if (atual.getElemento().equals(elemento)) {
        return (true);
      }
      atual = atual.getProxima();
    }
    return (false);
  }

  void imprimir(){

    if(this.TotaldeElementos == 0){
      System.out.println("A lista esta vazia!");
    }
    
    for(int i = 0; i < this.TotaldeElementos; i++){
      Paciente paciente = (Paciente) pega(i);
      System.out.println("Nome: "+paciente.Nome);
      System.out.println("Sexo: "+paciente.Sexo);
      System.out.println("Idade: "+paciente.Idade+"\n");
    }

  }

  int Tamanho() {
    return (this.TotaldeElementos);
  }

}