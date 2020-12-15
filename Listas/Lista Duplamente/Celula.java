public class Celula {

  
  Celula Proxima;
  Celula Anterior;
  Object Elemento;

  Celula(Celula proxima, Object elemento) {
    this.Proxima = proxima;
    this.Anterior = null;
    this.Elemento = elemento;
  }

  Celula(Object elemento) {
    this.Elemento = elemento;
    this.Anterior = null;
    this.Proxima = null;
  }

  void setProxima(Celula prox) {
    this.Proxima = prox;
  }

  void setAnterior(Celula ant) {
    this.Anterior = ant;
  }

  Celula getProxima() {
    return (this.Proxima);
  }

  Celula getAnterior() {
    return (this.Anterior);
  }

  Object getElemento() {
    return (this.Elemento);
  }

}