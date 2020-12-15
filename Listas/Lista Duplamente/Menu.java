public class Menu{
    public static void main(String[] args) throws Exception {
        ListaDupla lista = new ListaDupla();
        

        Paciente Homer = new Paciente();
        Homer.Nome = "Homer";
        Homer.Sexo = 'M';
        Homer.Idade = 56;


        Paciente Marge = new Paciente();
        Marge.Nome = "Marge";
        Marge.Sexo = 'F';
        Marge.Idade = 48;

        lista.adiciona(Homer);
        lista.adiciona(Marge);

        lista.imprimir();

        lista.EsvaziaLista();

        lista.imprimir();

        lista.adiciona(Homer);

        Paciente Bart = new Paciente();
        Bart.Nome = "Bart";
        Bart.Sexo = 'M';
        Bart.Idade = 12;

        Paciente Camila = new Paciente();
        Camila.Nome = "Camila";
        Camila.Sexo = 'F';
        Camila.Idade = 15;

        lista.AdicionaNoComeco(Bart);
        lista.Adiciona(1, Camila);

        lista.imprimir();

        lista.EsvaziaLista();

        Paciente Maggie = new Paciente();
        Maggie.Nome = "Maggie";
        Maggie.Sexo = 'F';
        Maggie.Idade = 2;

        Paciente Lisa = new Paciente();
        Lisa.Nome = "Lisa";
        Lisa.Sexo = 'F';
        Lisa.Idade = 15;

        lista.adiciona(Homer);
        lista.adiciona(Bart);
        lista.AdicionaNoComeco(Lisa);

        lista.imprimir();
        System.out.println("Tamanho da lista: "+lista.tamanho());

        lista.EsvaziaLista();
        lista.imprimir();

        lista.adiciona(Homer);
        lista.adiciona(Maggie);
        lista.AdicionaNoComeco(Bart);
        lista.Adiciona(1, Marge);

        lista.imprimir();

        if(!lista.Contem(Lisa)){
            System.out.println("Lisa não esta na lista");
        }
        else{
            System.out.println("Lisa esta na lista");
        }

        lista.EsvaziaLista();

        lista.adiciona(Homer);
        lista.adiciona(Bart);

        lista.imprimir();
        System.out.println("Tamanho da lista: "+lista.tamanho());

        if(!lista.Contem(Marge)){
            System.out.println("Marge não esta na lista");
        }
        else{
            System.out.println("Marge esta na lista");
        }

        if(!lista.Contem(Homer)){
            System.out.println("Homer não esta na lista");
        }
        else{
            System.out.println("Homer esta na lista");
        }        

        if(!lista.Contem(Bart)){
            System.out.println("Bart não esta na lista");
        }
        else{
            System.out.println("Bart esta na lista");
        }

        if(!lista.Contem(Maggie)){
            System.out.println("Maggie não esta na lista");
        }
        else{
            System.out.println("Maggie esta na lista");
        }

        System.out.println("Tamanho da lista: "+lista.tamanho());

        lista.EsvaziaLista();

        Paciente Jose = new Paciente();
        Jose.Nome = "Jose";
        Jose.Sexo = 'M';
        Jose.Idade = 50;

        Paciente Burns = new Paciente();
        Burns.Nome = "Burns";
        Burns.Sexo = 'M';
        Burns.Idade = 100;

        lista.adiciona(Homer);
        lista.adiciona(Bart);
        lista.adiciona(Marge);
        lista.Adiciona(0, Maggie);
        lista.AdicionaNoComeco(Jose);
        lista.adiciona(Burns);

        lista.imprimir();

        lista.RemovedoFim();
        lista.imprimir();

        lista.Remove(1);
        lista.imprimir();
        System.out.println("Tamanho da lista: "+lista.tamanho());

        if(!lista.Contem(Marge)){
            System.out.println("Marge não esta na lista");
        }
        else{
            System.out.println("Marge esta na lista");
        }

        if(!lista.Contem(Homer)){
            System.out.println("Homer não esta na lista");
        }
        else{
            System.out.println("Homer esta na lista");
        }        

        if(!lista.Contem(Bart)){
            System.out.println("Bart não esta na lista");
        }
        else{
            System.out.println("Bart esta na lista");
        }

        if(!lista.Contem(Maggie)){
            System.out.println("Maggie não esta na lista");
        }
        else{
            System.out.println("Maggie esta na lista");
        }

        System.out.println("Tamanho da lista: "+lista.tamanho());

        lista.RemoveDoComeco();
        lista.imprimir();
        System.out.println("Tamanho da lista: "+lista.tamanho());

        if(!lista.Contem(Marge)){
            System.out.println("Marge não esta na lista");
        }
        else{
            System.out.println("Marge esta na lista");
        }

        if(!lista.Contem(Homer)){
            System.out.println("Homer não esta na lista");
        }
        else{
            System.out.println("Homer esta na lista");
        }        

        if(!lista.Contem(Bart)){
            System.out.println("Bart não esta na lista");
        }
        else{
            System.out.println("Bart esta na lista");
        }

        if(!lista.Contem(Maggie)){
            System.out.println("Maggie não esta na lista");
        }
        else{
            System.out.println("Maggie esta na lista");
        }

        System.out.println("Tamanho da lista: "+lista.tamanho());

        lista.EsvaziaLista();
        lista.imprimir();



    }
}
