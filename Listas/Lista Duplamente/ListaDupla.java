public class ListaDupla {

  Celula Primeira;
  Celula Ultima;
  int TotaldeElementos = 0;

  void AdicionaNoComeco(Object elemento) {
    if (this.TotaldeElementos == 0) {
      Celula nova = new Celula(elemento);
      this.Primeira = nova;
      this.Ultima = nova;
    } else {
      Celula nova = new Celula(this.Primeira, elemento);
      this.Primeira.setAnterior(nova);
      this.Primeira = nova;
    }
    this.TotaldeElementos++;
  }

  void adiciona(Object elemento) {
    if (this.TotaldeElementos == 0) {
      this.AdicionaNoComeco(elemento);
    } else {
      Celula nova = new Celula(elemento);
      this.Ultima.setProxima(nova);
      nova.setAnterior(this.Ultima);
      this.Ultima = nova;
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

  void Adiciona(int pos, Object elemento) {
    if (pos == 0) {
      this.AdicionaNoComeco(elemento);
    } else if (pos == this.TotaldeElementos) {
      this.adiciona(elemento);
    } else {
      Celula anterior = this.PegaCelula(pos - 1);
      Celula proxima = anterior.getProxima();
      Celula nova = new Celula(anterior.getProxima(), elemento);
      nova.setAnterior(anterior);
      anterior.setProxima(nova);
      proxima.setAnterior(nova);
      this.TotaldeElementos++;
    }
  }

  Object pega(int posicao) {
    return (this.PegaCelula(posicao).getElemento());
  }

  void RemoveDoComeco() {
    if (!this.PosicaoOcupada(0)) {
      throw new IllegalArgumentException("Posição não Existe");
    } else {
      this.Primeira = this.Primeira.getProxima();
      this.TotaldeElementos--;
    }
    if (this.TotaldeElementos == 0) {
      this.Ultima = null;
    }
  }

  void RemovedoFim() {
    if (!this.PosicaoOcupada(TotaldeElementos - 1)) {
      throw new IllegalArgumentException("Posicao nao existe");
    } else {
      if (this.TotaldeElementos == 1) {
        this.RemoveDoComeco();
      } else {
        Celula penultima = this.Ultima.getAnterior();
        penultima.setProxima(null);
        this.Ultima = penultima;
        this.TotaldeElementos--;
      }
    }
  }

  void Remove(int pos) {
    if (!this.PosicaoOcupada(pos)) {
      throw new IllegalArgumentException("Posicao nao Existe");
    } else {
      if (pos == 0) {
        this.RemoveDoComeco();
      } else if (pos == this.TotaldeElementos - 1) {
        this.RemovedoFim();
      } else {
        Celula anterior = this.PegaCelula(pos - 1);
        Celula atual = anterior.getProxima();
        Celula proxima = atual.getProxima();
        anterior.setProxima(proxima);
        proxima.setAnterior(anterior);
        this.TotaldeElementos--;
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

  int tamanho() {
    return (this.TotaldeElementos);
  }

  void EsvaziaLista() {
    this.Primeira = null;
    this.Ultima = null;
    this.TotaldeElementos = 0;
  }

  String Imprimir() {
    if (this.TotaldeElementos == 0) {
      return ("[]");
    } else {
      StringBuilder builder = new StringBuilder("[");
      Celula atual = this.Primeira;
      for (int i = 0; i < this.TotaldeElementos - 1; i++) {
        builder.append(atual.getElemento());
        builder.append(", ");
        atual = atual.getProxima();
      }
      builder.append(atual.getElemento());
      builder.append("]");
      return (builder.toString());
    }
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

}