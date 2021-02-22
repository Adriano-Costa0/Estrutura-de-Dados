import javax.swing.JOptionPane;

public class CalculadoraPilha {
  String[] pilha = new String[10];
  int topoPilha = -1;

  public void esvazie_pilha() {
    this.topoPilha = -1;
    System.out.println("***** Esvaziando Pilha *****");
    System.out.println("***** Pilha Vazia! *****");
  }

  public int tamanho() {
    return (this.topoPilha + 1);
  }

  public void imprimir(int topo) {
    for (int i = topo; i > -1; i--) {
      System.out.println("Valor na pilha: " + this.pilha[i]);
    }
  }

  public int push(int topo, String num) {
    this.topoPilha = topo;
      this.pilha[this.topoPilha] = num;
      System.out.println("Inserindo o elemento: " + num);
      return (this.topoPilha);
    }

  public  String pop(int topo) {
    this.topoPilha = topo;

    if (this.topoPilha < -1) {
      JOptionPane.showMessageDialog(null, "Pilha Vazia. Erro 998");
      return ("Pilha vazia");
    } else {
      this.topoPilha--;
      System.out.println("retirando o valor:" + this.pilha[this.topoPilha + 1]);
      return (this.pilha[this.topoPilha + 1]);
    }
  }

  public String top(int topo){
    this.topoPilha = topo;
    if(this.topoPilha < 0){
      JOptionPane.showMessageDialog(null,"Pilha Vazia. Erro 997");
      return ("Pilha vazia");
    }else {
      return(this.pilha[this.topoPilha]);
    }
  }
  
}