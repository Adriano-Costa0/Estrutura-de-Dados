import java.util.Scanner;

public class Calcula {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CalculadoraPilha obj;

        String operacao = "";
        do {
            System.out.println("Insira uma operação");
            operacao = scan.nextLine();

            obj = fatiar(operacao);
            remontar(obj);
            remontarPreFixa(obj);
        } while (true);
    }

    public static CalculadoraPilha fatiar(String operacao) {
        String operacaoSplit[] = operacao.split("\\+|\\-|\\*|\\/");
        String aux = "";
        for (String num : operacaoSplit) {
            System.out.println(num + "|");
        }
        for (int i = 0; i < operacaoSplit.length; i++) {

            String opBasicas[] = operacao.split(operacaoSplit[i]);

            for (String num : opBasicas) {
                if (i == operacaoSplit.length - 1) {
                    aux = num;
                } else {
                    aux += num;
                }
            }
            operacao = aux;
        }
        String operacoes[] = aux.split("");

        CalculadoraPilha obj = new CalculadoraPilha();

        int size = operacaoSplit.length + operacoes.length;
        int pos = 0;
        for (int j = 0; j < size; j++) {
            if (j + 1 == operacaoSplit.length) {
                obj.push(pos, operacaoSplit[j]);
                pos++;
                break;
            }
            obj.push(pos, operacaoSplit[j]);
            pos++;
            obj.push(pos, operacoes[j]);
            pos++;

        }
        return obj;

    }

    public static void remontar(CalculadoraPilha operacao) {
        String posFixa = "";
        String result = "";
        int size = operacao.tamanho() - 1;

        for (int i = 0; i <= size; i++) {
            result = operacao.pop(i);
            if (result.equals("+") || result.equals("-") || result.equals("*") || result.equals("/")) {
                if (operacao.top(i + 1) != "+" || operacao.top(i + 1) != "-" || operacao.top(i + 1) != "*"
                        || operacao.top(i + 1) != "/") {
                    posFixa += operacao.pop(i + 1) + result;
                    i++;
                }
            } else {
                posFixa += result;
            }
        }
        System.out.println("Notação Polonesa Reversa: " + posFixa);

    }

    public static void remontarPreFixa(CalculadoraPilha operacao) {
        String preFixa = "";
        String aux = "";
        String result = "";
        int size = operacao.tamanho();

        for (int i = 0; i <= size; i++) {
            result = operacao.pop(i);
            if (result.equals("+") || result.equals("-") || result.equals("*") || result.equals("/")) {
                if (operacao.top(i + 1) != "+" || operacao.top(i + 1) != "-" || operacao.top(i + 1) != "*"
                        || operacao.top(i + 1) != "/") {
                    preFixa = result + preFixa;

                }
                aux += preFixa;
                preFixa = "";

            } else {
                preFixa += result;
                if (aux.equals("")) {

                } else {
                    aux += result;
                    preFixa = "";
                }
            }

        }
        System.out.println("Notação Polonesa: " + aux);

    }
}