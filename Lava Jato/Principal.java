import java.util.Random;
import java.util.Scanner;


public class Principal {

public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    int option;

    LavaJato filaLavaJato = new LavaJato();
    LavaJato filaLavados = new LavaJato();
    

    Carro car1 = new Carro();
    car1.cor = "preto";
    car1.placa = "JHG564";
    car1.modelo = "Fusca";
    car1.numChassi = 45625;
    car1.ano = 1995;
    car1.numPortas = 3;
    car1.id = gerarId();
    filaLavaJato.inserir(car1);

    Carro car2 = new Carro();
    car2.cor = "preto";
    car2.placa = "PGF856";
    car2.modelo = "Corola";
    car2.numChassi = 896574;
    car2.ano = 2095;
    car2.numPortas = 5;
    car2.id = gerarId();
    filaLavaJato.inserir(car2);

    Carro car3 = new Carro();
    car3.cor = "Rosa";
    car3.placa = "YUH875";
    car3.modelo = "Honda";
    car3.numChassi = 45625;
    car3.ano = 2012;
    car3.numPortas = 4;
    car3.id = gerarId();
    filaLavaJato.inserir(car3);

    Carro car4 = new Carro();
    car4.cor = "Cinza";
    car4.placa = "YLW666";
    car4.modelo = "Tesla";
    car4.numChassi = 25684;
    car4.ano = 2018;
    car4.numPortas = 3;
    car4.id = gerarId();
    filaLavaJato.inserir(car4);

    Carro car5 = new Carro();
    car5.cor = "Azul";
    car5.placa = "UTG857";
    car5.modelo = "AppleCar";
    car5.numChassi = 875412;
    car5.ano = 2023;
    car5.id = gerarId();
    filaLavaJato.inserir(car5);

    Motocicleta moto1 = new Motocicleta();
    moto1.cor = "Vermelha";
    moto1.placa = "KJH564";
    moto1.modelo = "Susuki";
    moto1.numChassi = 85642;
    moto1.ano = 2001;
    moto1.id = gerarId();
    filaLavaJato.inserir(moto1);

    Motocicleta moto2 = new Motocicleta();
    moto2.cor = "Prata";
    moto2.placa = "KJI813";
    moto2.modelo = "Susuki";
    moto2.numChassi = 96642;
    moto2.ano = 2011;
    moto2.id = gerarId();
    filaLavaJato.inserir(moto2);

    Motocicleta moto3 = new Motocicleta();
    moto3.cor = "Vermelha";
    moto3.placa = "KJH564";
    moto3.modelo = "Susuki";
    moto3.numChassi = 85642;
    moto3.ano = 2001;
    moto3.id = gerarId();
    filaLavaJato.inserir(moto3);

    Motocicleta moto4 = new Motocicleta();
    moto4.cor = "Branco";
    moto4.placa = "KLI854";
    moto4.modelo = "Titan";
    moto4.numChassi = 87541;
    moto4.ano = 2005;
    moto4.id = gerarId();
    filaLavaJato.inserir(moto4);

    Motocicleta moto5 = new Motocicleta();
    moto5.cor = "Preto";
    moto5.placa = "PQM995";
    moto5.modelo = "Biz";
    moto5.numChassi = 32541;
    moto5.ano = 2012;
    moto5.id = gerarId();
    filaLavaJato.inserir(moto5);

    Caminhao caminhao1 = new Caminhao();
    caminhao1.cor = "Preto";
    caminhao1.placa = "JHG8566";
    caminhao1.modelo = "Coca Cola";
    caminhao1.numChassi = 895647;
    caminhao1.ano = 2000;
    caminhao1.id = gerarId();
    filaLavaJato.inserir(caminhao1);

    Caminhao caminhao2 = new Caminhao();
    caminhao2.cor = "Preto";
    caminhao2.placa = "WWW666";
    caminhao2.modelo = "Vizzano";
    caminhao2.numChassi = 753698;
    caminhao2.ano = 2015;
    caminhao2.id = gerarId();
    filaLavaJato.inserir(caminhao2);

    Caminhao caminhao3 = new Caminhao();
    caminhao3.cor = "Branco";
    caminhao3.placa = "KKJ756";
    caminhao3.modelo = "Navesgane";
    caminhao3.numChassi = 758431;
    caminhao3.ano = 2010;
    caminhao3.id = gerarId();
    filaLavaJato.inserir(caminhao3);

    Caminhao caminhao4 = new Caminhao();
    caminhao4.cor = "Prata";
    caminhao4.placa = "UUY852";
    caminhao4.modelo = "Cinderela";
    caminhao4.numChassi = 468723;
    caminhao4.ano = 1999;
    caminhao4.id = gerarId();
    filaLavaJato.inserir(caminhao4);

    Caminhao caminhao5 = new Caminhao();
    caminhao5.cor = "Azul";
    caminhao5.placa = "LGC521";
    caminhao5.modelo = "Barroso";
    caminhao5.numChassi = 897541;
    caminhao5.ano = 2020;
    caminhao5.id = gerarId();
    filaLavaJato.inserir(caminhao5);





    System.out.println("Lava Jato - ta na fila\n");
    
    do {
         
        if(filaLavaJato.fila.size() >3 ){
            Object objAux = filaLavaJato.remover();
            filaLavados.inserir(objAux);
        }

        System.out.println("Selecione a opção:\n1- Ver fila de espera\n2- Ver fila de veiculos lavados\n3- adicionar veiculo a fila de espera");
        option = scan.nextInt();

        switch(option){
            case 1:
                System.out.println("FILA DE ESPERA");
                imprimirFilas(filaLavaJato);
                break;

            case 2:
                System.out.println("FILA DE LAVADOS");
                imprimirFilas(filaLavados);
                break;

            case 3:
                Object obj = new Object();
                obj = addAutomovel();
                filaLavaJato.inserir(obj);
                break;
        }

    } while (option != 0);
    scan.close();

}

public static int gerarId() {
    Random aleatorio = new Random();
    return aleatorio.nextInt(100) + 1;
}

public static Object addAutomovel() {
    int option;
    Scanner scan = new Scanner(System.in);
    System.out.println("Qual o tipo de Automovel: \n1-Carro \n2-Motocicleta \n3-Caminhao");
    option = scan.nextInt();

    switch (option) {
        case 1:
            Carro newCarro = new Carro();
            scan.nextLine();

            System.out.println("Qual a cor : ");
            newCarro.cor = scan.nextLine();

            System.out.println("Qual a placa: ");
            newCarro.placa = scan.nextLine();

            System.out.println("Qual o modelo: ");
            newCarro.modelo = scan.nextLine();

            System.out.println("Qual o numero do chassi :");
            newCarro.numChassi = scan.nextInt();

            System.out.println("Qual o ano: ");
            newCarro.ano = scan.nextInt();

            System.out.println("Quantas portas tem o carro : ");
            newCarro.numPortas = scan.nextInt();

            newCarro.id = gerarId();
            return newCarro;
        case 2:

            Motocicleta newMotocicleta = new Motocicleta();
            scan.nextLine();

            System.out.println("Qual a cor : ");
            newMotocicleta.cor = scan.nextLine();

            System.out.println("Qual a placa: ");
            newMotocicleta.placa = scan.nextLine();

            System.out.println("Qual o modelo: ");
            newMotocicleta.modelo = scan.nextLine();

            System.out.println("Qual o numero do chassi :");
            newMotocicleta.numChassi = scan.nextInt();

            System.out.println("Qual o ano: ");
            newMotocicleta.ano = scan.nextInt();

            newMotocicleta.id = gerarId();

            return newMotocicleta;

        case 3:

            Caminhao newCaminhao = new Caminhao();
            scan.nextLine();

            System.out.println("Qual a cor : ");
            newCaminhao.cor = scan.nextLine();

            System.out.println("Qual a placa: ");
            newCaminhao.placa = scan.nextLine();

            System.out.println("Qual o modelo: ");
            newCaminhao.modelo = scan.nextLine();

            System.out.println("Qual o numero do chassi :");
            newCaminhao.numChassi = scan.nextInt();

            System.out.println("Qual o ano: ");
            newCaminhao.ano = scan.nextInt();

            System.out.println("Quantos eixos tem : ");
            newCaminhao.numEixos = scan.nextInt();

            newCaminhao.id = gerarId();
            return newCaminhao;

        default:
            System.out.println("Opção Invalida");
    }
    return null;
}

    public static void imprimirFilas(Object fila) {
        LavaJato filaAux = (LavaJato) fila;
        Object obj = new Object();

        if(filaAux.filaVazia()){
            System.out.println("A fila esta vazia");
            return;
        }
        else{

        for (int i = 0; i < filaAux.fila.size(); i++) {
            obj = filaAux.fila.get(i);
                if(obj instanceof Carro){
                    Carro carAux = new Carro();
                    carAux = (Carro)obj;
                    System.out.println("Id: "+carAux.id);
                    System.out.println("Cor do carro: "+ carAux.cor);
                    System.out.println("Placa: "+ carAux.placa);
                    System.out.println("Modelo: "+ carAux.modelo);
                    System.out.println("Numero do chassi: "+ carAux.numChassi);
                    System.out.println("Ano: "+ carAux.ano);
                    System.out.println("Numero de portas: "+ carAux.numPortas+ "\n");

                } 
                else if ( obj instanceof Motocicleta){
                    Motocicleta motoAux = new Motocicleta();
                    motoAux = (Motocicleta)obj;

                    System.out.println("Id: "+motoAux.id);
                    System.out.println("Cor da Moto: "+ motoAux.cor);
                    System.out.println("Placa: "+ motoAux.placa);
                    System.out.println("Modelo: "+ motoAux.modelo);
                    System.out.println("Numero do chassi: "+ motoAux.numChassi);
                    System.out.println("Ano: "+ motoAux.ano+"\n");
                    
                }
               
                else if ( obj instanceof Caminhao){
                    Caminhao caminhaoAux = new Caminhao();
                    caminhaoAux =(Caminhao) obj;
                    System.out.println("Id: "+caminhaoAux.id);
                    System.out.println("Cor do Caminhao: "+ caminhaoAux.cor);
                    System.out.println("Placa: "+ caminhaoAux.placa);
                    System.out.println("Modelo: "+ caminhaoAux.modelo);
                    System.out.println("Numero do chassi: "+ caminhaoAux.numChassi);
                    System.out.println("Ano: "+ caminhaoAux.ano);
                    System.out.println("Numero de Eixos: "+ caminhaoAux.numEixos+ "\n");
                }
    }
}  

}

}