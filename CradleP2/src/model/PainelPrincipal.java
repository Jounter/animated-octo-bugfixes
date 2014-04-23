package model;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.utils.FileHandler;

public class PainelPrincipal extends Iteravel {
	private Grelha[][] grelha;
	private Jogo jogo;
	private GridPanel gridPanel;
//	private Elemento[][] elementos;
	private static final String BLOCO = "B";
	private static final String PAREDE = "P";
	private static final String COFRE = "S";

	public PainelPrincipal(GridPanel gridPanel, Jogo jogo) {
		this.gridPanel = gridPanel;
		this.jogo = jogo;
		grelha = new Grelha[18][9];
		
		carregarFicheiroNivel();
	}

	private void carregarFicheiroNivel() {
		FileHandler handler = new FileHandler("/niveis/nivelOptimizado.txt");
		String conteudo = handler.readFile();
		String[] colunas = null;
		
		int y = 0;
		
		for (String linha: conteudo.split("\n")) {
			colunas = linha.split(" ");
			for(int x = 0; x < colunas.length; x++){
				if (colunas[x].substring(0, 1).equals(PAREDE)){
					adicionarGrelha(new Parede(new Posicao(y, x), this));
				}
				if (colunas[x].substring(0, 1).equals(BLOCO)){
					adicionarGrelha(new Bloco(new Posicao(y, x), this, Integer.parseInt(colunas[x].substring(1, 2))));
					switch (Integer.parseInt(colunas[x].substring(2, 3).intern())) {
					case 0:
						pintar(grelha[x][y]);
						break;					
					case 1:
						adicionarElemento(new Anel(new Posicao(y, x)));
						break;
					case 2:
						adicionarElemento(new Balde(new Posicao(y, x)));
						break;
					case 3:
						adicionarElemento(new Bomba(new Posicao(y, x)));
						break;
					case 4:
						adicionarElemento(new Camarao(new Posicao(y, x)));
						break;
					case 5:
						adicionarElemento(new Carne(new Posicao(y, x)));
						break;
					case 6:
						adicionarElemento(new Elmo(new Posicao(y, x)));
						break;
					case 7:
						adicionarElemento(new Folha(new Posicao(y, x)));
						break;
					case 8:
						adicionarElemento(new Madeira(new Posicao(y, x)));
						break;
					case 9:
						adicionarElemento(new Martelo(new Posicao(y, x)));
						break;
					}
					if(colunas[x].substring(3, 4).equals(COFRE)){
						((Bloco)grelha[x][y]).getElemento().setCorrente(new Corrente(new Posicao(y, x)));
						pintar(grelha[x][y]);
					}
				}
			}
			y++;
		}
		
	}


	private void adicionarElemento(Elemento elemento) {
		/////REVER COM PROF/////
		((Bloco)grelha[elemento.getPosicao().getColuna()][elemento.getPosicao().getLinha()]).setElemento(elemento);
		pintar(grelha[elemento.getPosicao().getColuna()][elemento.getPosicao().getLinha()]);
	}
	
	private void adicionarGrelha(Grelha eleGrelha) {
		grelha[eleGrelha.getPosicao().getColuna()][eleGrelha.getPosicao().getLinha()] = eleGrelha;
		if(grelha[eleGrelha.getPosicao().getColuna()][eleGrelha.getPosicao().getLinha()] instanceof Parede){
			pintar(eleGrelha);
		}
	}
	
	private void pintar(Grelha eleGrelha) {
		gridPanel.put(eleGrelha.getPosicao().getColuna(), eleGrelha.getPosicao().getLinha(), eleGrelha.getCellRepresentation());
	}

	public void iterar() {
		
	}

}
