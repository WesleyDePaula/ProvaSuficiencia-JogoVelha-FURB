package br.furb.jogovelha;

import java.util.Scanner;

public class JogoDaVelha {

	private static JogoDaVelhaMapa jogoMapa;
	private static JogoDaVelhaJogador jogoJogador;
	private static JogoDaVelhaPc jogoPc;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		jogoMapa = new JogoDaVelhaMapa();
		jogoJogador = new JogoDaVelhaJogador(jogoMapa);
		jogoPc = new JogoDaVelhaPc(jogoMapa);

		char jogarNovamente;
		do {
			jogoMapa.limpaMapa();
			jogar(scanner);
			System.out.println("Deseja jogar novamente? s/n");
			jogarNovamente = scanner.next().charAt(0);
		} while (jogarNovamente == 's');

	}

	private static void jogar(Scanner scanner) {
		int jogada = +0;
		boolean isGanhador = false;
		int vezJogar = jogoMapa.sortear(1, 2);
		do {
			jogoMapa.desenhar(jogada);
			isGanhador = vezJogar == 1 ? jogoJogador.joga(scanner) : jogoPc.joga();
			if (!isGanhador && jogoMapa.isEmpate()) {
				System.out.println("... EMPATOU!");
				jogoMapa.desenhar(jogada);
				return;
			}
			vezJogar = vezJogar == 1 ? 2 : 1;
			
			jogada++;
		} while (!isGanhador);
		jogoMapa.desenhar(jogada);
	}

}
