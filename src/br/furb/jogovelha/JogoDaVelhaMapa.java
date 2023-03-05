package br.furb.jogovelha;

public class JogoDaVelhaMapa {

	private char[][] mapa = new char[3][3];

	/**
	 * Sorteia a jogada do PC
	 * @param inicio
	 * @param fim
	 * @return posição da jogada
	 */
	public int sortear(int inicio, int fim) {
		return inicio + (int) (Math.random() * (fim - inicio + 1));
	}

	/**
	 * Limpa o "tabuleiro" do jogo para uma nova partida
	 */
	public void limpaMapa() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				this.mapa[i][j] = ' ';
			}
		}
	}

	/**
	 * Desenha o a jogada no "tabuleiro"
	 * @param jogada
	 */
	public void desenhar(int jogada) {
		System.out.println("--------------- .. jogada: " + jogada);
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				System.out.print("| " + this.mapa[i][j] + " |");
			}
			System.out.println("\n---------------");
		}
	}

	/**
	 * Realiza a jogada do Jogador/PC
	 * @param l = linha
	 * @param c = coluna
	 * @param jogador = letra do jogador
	 * @return true, se a jogada é válida
	 */
	public boolean jogar(int l, int c, char jogador) {

		try {
			if (mapa[l][c] == ' ') {
				mapa[l][c] = jogador;
			} else {
				return false;
			}
		} catch (IndexOutOfBoundsException ex) {
			return false;
		}

		return true;
	}

	/**
	 * Verifica se o jogador/pc ganhou a partida
	 * @param jogador
	 * @return true, se ganhou
	 */
	public boolean ganhou(char jogador) {

		for (int i = 0; i < mapa.length; i++) {
			// Checa a linha
			if (mapa[i][0] == jogador && mapa[i][1] == jogador && mapa[i][2] == jogador) {
				return true;
			}
			// Checa a coluna
			if (mapa[0][i] == jogador && mapa[1][i] == jogador && mapa[2][i] == jogador) {
				return true;
			}
		}

		// Checa a diagonal principal
		int qtdDiagonalPrimaria = 0;
		for (int i = 0; i < mapa.length; i++) {
			if (mapa[i][i] == jogador) {
				qtdDiagonalPrimaria++;
			}
		}

		// Checa a diagonal secundária
		int qtdDiagonalSecundaria = 0;
		for (int i = 0; i < mapa.length; i++) {
			if (mapa[i][mapa.length - 1 - i] == jogador) {
				qtdDiagonalSecundaria++;
			}
		}
		if (qtdDiagonalPrimaria == 3 || qtdDiagonalSecundaria == 3) {
			return true;
		}

		return false;
	}

	/**
	 * Valida se houve empate na partida
	 * @return true, se houve empate
	 */
	public boolean isEmpate() {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if (mapa[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

}
