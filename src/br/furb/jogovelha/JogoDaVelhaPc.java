package br.furb.jogovelha;

public class JogoDaVelhaPc {
	
	private JogoDaVelhaMapa mapa;
	private char letra = 'O';
	
	public JogoDaVelhaPc(JogoDaVelhaMapa mapa) {
		this.mapa = mapa;
	}
	
	
	/**
	 * Realiza a jogada do PC                                                                                                                                                                               
	 * @return true, se ganhou a jogada
	 */
	public boolean joga() {
		boolean jogadaValida;
		do {
			jogadaValida = mapa.jogar(mapa.sortear(0, 2), mapa.sortear(0, 2), letra);
		} while (!jogadaValida);
		

		if (mapa.ganhou(letra)) {
			System.err.println("... PC GANHOU!");
			return true;
		} 
		return false;
	}
	

}
