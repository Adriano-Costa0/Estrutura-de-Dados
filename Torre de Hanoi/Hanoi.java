import java.util.Stack;

public class Hanoi {

	
	private static Stack<String> pilha = new Stack<String>();
	private static long numMovimentos;

	private static void mover(int origem, int destino) {
		numMovimentos++;
		System.out.println("[" + numMovimentos + "]:" + origem + " -> " + destino);
	}

	public static void hanoi(int numDisco) {

		int pinoOrigem = 1;
		int pinoDestino = 3; 
		int pinoAtual = 2;

		
		String comandoAtual = numDisco + "," + pinoOrigem + "," + pinoDestino + "," + pinoAtual;

		pilha.push(comandoAtual);

		while (!pilha.empty()) {

			
			if (numDisco > 1) {

				
				numDisco--;
				String[] vetAux = comandoAtual.split(",");
				pinoOrigem = Integer.parseInt(vetAux[1]);
				pinoDestino = Integer.parseInt(vetAux[2]);
				pinoAtual = Integer.parseInt(vetAux[3]);

				
				comandoAtual = numDisco + "," + pinoOrigem + "," + pinoAtual + "," + pinoDestino;

				pilha.push(comandoAtual);

				
			} else {

				
				comandoAtual = pilha.pop();

				String[] vetAux = comandoAtual.split(",");
				numDisco = Integer.parseInt(vetAux[0]);
				pinoOrigem = Integer.parseInt(vetAux[1]);
				pinoDestino = Integer.parseInt(vetAux[2]);
				pinoAtual = Integer.parseInt(vetAux[3]);


				mover(pinoOrigem, pinoDestino);

				if (numDisco > 1) {
					numDisco--;
					comandoAtual=numDisco + "," + pinoAtual + "," + pinoDestino + "," + pinoOrigem;
					pilha.push(comandoAtual);
				}

			}

		}

	}

}