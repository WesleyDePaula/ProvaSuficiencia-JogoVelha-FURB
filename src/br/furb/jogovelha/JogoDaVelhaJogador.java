package br.furb.jogovelha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoDaVelhaJogador {

	private JogoDaVelhaMapa mapa;
	private char letra = 'X';

	public JogoDaVelhaJogador(JogoDaVelhaMapa mapa) {
		this.mapa = mapa;
	}

	/**
	 * Pega os input do jogador e realiza a jogada
	 * 
	 * @param scanner
	 * @return true, se ganhou
	 */
	public boolean joga(Scanner scanner) {
		boolean jogadaValida = false;
		do {
			try {
				System.out.println("Jogador ..");
				System.out.println("  linha:");
				int linha = scanner.nextInt();

				System.out.println("  coluna:");
				int coluna = scanner.nextInt();

				jogadaValida = mapa.jogar(linha, coluna, letra);
				if (!jogadaValida) {
					System.out.println("Jogada inválida, jogue novamente!");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Jogada inválida, jogue novamente!");
				scanner.next();
			}
		} while (!jogadaValida);

		if (mapa.ganhou(letra)) {
			System.err.println("... Jogador GANHOU!");
			return true;
		}
		return false;
	}

}
