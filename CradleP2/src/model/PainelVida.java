package model;


import javax.swing.JPanel;


public class PainelVida extends Iteravel {
	private JPanel jPanel;
	private Jogo jogo;
	private int nivelVida;
	
	
//	private static final representacaoVisual = new representacaoVisual, new MultipleImageCellRepresentation(100, true, true, 
//			"/imagens/vida_0.png", "/imagens/vida_1.png", "/imagens/vida_2.png", 
//			"/imagens/vida_3.png", "/imagens/vida_4.png", "/imagens/vida_5.png", 
//			"/imagens/vida_6.png", "/imagens/vida_7.png", "/imagens/vida_8.png", 
//			"/imagens/vida_9.png", "/imagens/vida_10.png", "/imagens/vida_11.png",
//			"/imagens/vida_12.png", "/imagens/vida_13.png", "/imagens/vida_14.png", 
//			"/imagens/vida_15.png", "/imagens/vida_16.png", "/imagens/vida_17.png", 
//			"/imagens/vida_18.png", "/imagens/vida_19.png", "/imagens/vida_20.png");
//}

	public PainelVida(JPanel jPanel, Jogo jogo) {
		this.jPanel = jPanel;
		this.jogo = jogo;
		nivelVida = 20;
}
	
	public int getNivelVida(){
		if(nivelVida > 0){
		int nivelVidaAux = nivelVida;
		nivelVida = nivelVidaAux - 1;
		}else {
			nivelVida = 0;
		}
		return nivelVida;
	}
}
