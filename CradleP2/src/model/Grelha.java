package model;

public class Grelha {
	private Posicao posicao;
	private PainelPrincipal painelPrincipal;
	
	
	public Grelha(Posicao posicao, PainelPrincipal painelPrincipal) {
		super();
		this.posicao = posicao;
		this.painelPrincipal = painelPrincipal;
	}

	public Posicao getPosicao() {
		return posicao;
	}

}
