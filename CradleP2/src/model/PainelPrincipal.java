package model;

import java.util.LinkedList;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.utils.FileHandler;

public class PainelPrincipal extends Iteravel {
	private Celula[][] grelha;
	private Jogo jogo;
	private GridPanel gridPanel;
	private LinkedList<Bloco> listaBlocos;
	private static final String BLOCO = "B";
	private static final String PAREDE = "P";
	private static final String CORRENTE = "C";

	public PainelPrincipal(GridPanel gridPanel, Jogo jogo) {
		this.gridPanel = gridPanel;
		this.jogo = jogo;
		grelha = new Celula[18][9];
		listaBlocos = new LinkedList<>();
		
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
					Parede parede = new Parede(new Posicao(y, x), this);
					adicionarCelula(parede, x , y);
					gridPanel.put(x, y, parede.getCellRepresentation());
				}
				if (colunas[x].substring(0, 1).equals(BLOCO)){
					Bloco bloco = new Bloco(new Posicao(y, x), this, Integer.parseInt(colunas[x].substring(1, 2)));
					adicionarCelula(bloco, x , y);
					listaBlocos.add(bloco);
					switch (Integer.parseInt(colunas[x].substring(2, 3).intern())) {
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
					if(colunas[x].substring(3, 4).equals(CORRENTE)){
						((Bloco)grelha[x][y]).getElemento().setCorrente(new Corrente(new Posicao(y, x)));
					}
					atualizar();
				}
			}
			y++;
		}
		
	}


	private void adicionarElemento(Elemento elemento) {
		((Bloco)grelha[elemento.getPosicao().getColuna()][elemento.getPosicao().getLinha()]).setElemento(elemento);
	}
	
	private void adicionarCelula(Celula eleGrelha, int x, int y) {
		grelha[x][y] = eleGrelha;
	}
	
	private void atualizar() {
		for (Bloco bloco : listaBlocos) {
			gridPanel.put(bloco.getPosicao().getColuna(), bloco.getPosicao().getLinha(), bloco.getCellRepresentation());
		}
	}

	public void iterar() {
		
	}

}
