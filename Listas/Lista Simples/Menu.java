public class Menu{
    public static void main(String[] args) throws Exception {
        ListaLigada lista = new ListaLigada();
        
        Paciente pac1 = new Paciente();
        pac1.Nome = "Adriano";
        pac1.Idade = 19;
        pac1.Sexo = 'M';

        Paciente pac2 = new Paciente();
        pac2.Nome = "Paulo";
        pac2.Idade = 25;
        pac2.Sexo = 'M';

        Paciente pac3 = new Paciente();
        pac3.Nome = "Maria";
        pac3.Idade = 20;
        pac3.Sexo = 'F';
        
        Paciente pac4 = new Paciente();
        pac4.Nome = "Ana Luiza";
        pac4.Idade = 17;
        pac4.Sexo = 'N';

        Paciente pac5 = new Paciente();
        pac5.Nome = "Pedro";
        pac5.Idade = 16;
        pac5.Sexo = 'M';

        lista.adiciona(pac1);
        lista.adiciona(pac3);
        lista.adiciona(pac5);
        lista.adiciona(pac2);
        lista.adiciona(pac4);

        lista.imprimir();

        lista.removeDoComeco();

        Paciente pac6 = new Paciente();
        pac6.Nome = "Ana Julia";
        pac6.Idade = 15;
        pac6.Sexo = 'F';

        Paciente pac7 = new Paciente();
        pac7.Nome = "Marinho";
        pac7.Idade = 30;
        pac7.Sexo = 'M';

        lista.adiciona(1, pac6);
        lista.adiciona(1, pac7);
        

        System.out.println("Lista Atualizada\n");
        
        lista.imprimir();
    }
}