package puzzle8SistemasInteligentes;

import java.util.Scanner;

public class main {

	public static void imprimir(int[][] matriz) {
		System.out.println("\nA Matriz ficou: \n");
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				System.out.printf("\t %d \t", matriz[linha][coluna]);
			}
			System.out.println();
		}
	}

	public static int[][] criarMatriz(int[][] matriz) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Matriz M[3][3]\n");

		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				System.out.printf("Insira o elemento M[%d][%d]: ", linha + 1, coluna + 1);
				matriz[linha][coluna] = entrada.nextInt();
			}
		}
		return matriz;
	}

	public static void calculaDistancia(int[][] matriz, int objetivo[][]) {
		int disttotal = 0;
		for (int linhaob = 0; linhaob < 3; linhaob++) {
			for (int colunaob = 0; colunaob < 3; colunaob++) {
				int valorob = objetivo[linhaob][colunaob];
				for (int linhama = 0; linhama < 3; linhama++) {
					for (int colunama = 0; colunama < 3; colunama++) {
						int valorma = matriz[linhama][colunama];
						int distvalor = 0;
						if (valorob == valorma) {
							int distcol = colunaob - colunama;
							int distlin = linhaob - linhama;
							distvalor = Math.abs(distcol) + Math.abs(distlin);
							System.out.println("valorob: " + valorob + "distvalor: " + distvalor);
						}
						disttotal += distvalor;
					}
				}
			}
		}
		System.out.println("disttotal" + disttotal);
	}

	public static void main(String[] args) {

		// matriz objetivo
		int objetivo[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// matriz criada
		int matriz[][] = new int[3][3];

		// pede para usuario criar matriz
		criarMatriz(matriz);

		// imprime matriz criada
		imprimir(matriz);

		calculaDistancia(matriz, objetivo);

	}

}