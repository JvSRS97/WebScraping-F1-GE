package jvreis.webscrapingf1.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


import jvreis.webscrapingf1.classes.Dados;
import jvreis.webscrapingf1.classes.Equipe;
import jvreis.webscrapingf1.classes.Piloto;

import jvreis.webscrapingf1.classes.Dados;
import jvreis.webscrapingf1.classes.Equipe;
import jvreis.webscrapingf1.classes.Piloto;


public class ScrapingConfiguration {// obs.: editar caminho do arquivo em caso de mudan�a de pasta
	private String path = "C:\\Users\\jvict\\eclipse-workspace\\webscrapingf1\\ScrapingFile-Pilotos.txt";
	private String path_2 = "C:\\Users\\jvict\\eclipse-workspace\\webscrapingf1\\ScrapingFile-Equipes.txt";
	// caminho para o arquivo a ser gravado

	private OutputStreamWriter writer;// para escrever no arquivo

	public ScrapingConfiguration() {// construtor que chamar� m�todo
		executar();// m�todo para executar scraping
	}

	// ------------------------------------------------------------------
	private void escreverFile(String texto, String caminho) {// fun��o para escrever texto no arquivo
		try {
			File arquivo = new File(caminho);// declarando vari�vel do tipo File chamada "arquivo" com o caminho "path"
												// declarado l� em cima
			if (!arquivo.exists()) {// se arquivo n�o existe [note "!" antes]
				arquivo.createNewFile();// criando arquivo
			}
			writer = new OutputStreamWriter(new FileOutputStream(arquivo));// para escrever arquivo
			writer.write(texto);
			writer.flush();// limpar mem�ria do writer
		} catch (Exception e) {
			e.printStackTrace();// imprime informa��es sobre erro, caso ocorra
		}
	}

	// ------------------------------------------------------------------
	private void executar() {
		Dados dados;
		dados = new Dados();
		
		// chamando funcao search da classe Scrap que retorna dados (olhar estrutura Dados)
		dados = Scraping.search();
		

		imprimir_lista_p(dados.pilotos);
		escreverFile(list_to_txt_p(dados.pilotos), path);
		
		imprimir_lista_e(dados.equipes);
		escreverFile(list_to_txt_e(dados.equipes), path_2);
	}

	private void imprimir_lista_p(List<Piloto> pilotos) {// imprimindo a lista
		int i;
		String posicao, piloto, pais, equipe, pontuacao;
		System.out.println("Classificação de Pilotos");
		for (i = 1; i < pilotos.size(); i++) {
			posicao = pilotos.get(i).getPosicao();
			piloto = pilotos.get(i).getPiloto();
			pais = pilotos.get(i).getPais();
			equipe = pilotos.get(i).getEquipe();
			pontuacao = pilotos.get(i).getPontuacao();
			System.out.println("Posição: " + posicao + "; Piloto: " + piloto + "; País: " + pais + "; Equipe: " + equipe
					+ "; Pontuação: " + pontuacao + ".");
		}
	}

	private void imprimir_lista_e(List<Equipe> equipes) {// imprimindo a lista
		int i;
		String posicao, equipe, pontuacao;
		System.out.println("\nClassificação de Equipes");
		for (i = 1; i < equipes.size(); i++) {
			posicao = equipes.get(i).getPosicao();
			equipe = equipes.get(i).getEquipe();
			pontuacao = equipes.get(i).getPontuacao();
			System.out.println("Posição: " + posicao + "; Equipe: " + equipe + "; Pontuação: " + pontuacao + ".");
		}
	}
	private String list_to_txt_p(List<Piloto> pilotos) {// convertendo lista em texto numa única variável
		String texto = "Posição\tPiloto\tPaís\tEquipe\tPontuação\n";
		int i;
		String posicao, piloto, pais, equipe, pontuacao;
		for (i = 1; i < pilotos.size(); i++) {
			posicao = pilotos.get(i).getPosicao();
			piloto = pilotos.get(i).getPiloto();
			pais = pilotos.get(i).getPais();
			equipe = pilotos.get(i).getEquipe();
			pontuacao = pilotos.get(i).getPontuacao();
			texto += posicao + "\t" + piloto + "\t" + pais + "\t" + equipe + "\t" + pontuacao + ".\n";
		}

		return texto;
	}
	
	private String list_to_txt_e(List<Equipe> equipes) {// convertendo lista em texto numa única variável
		String texto = "Posição\tEquipe\tPontuação\n";
		int i;
		String posicao, equipe, pontuacao;
		for (i = 1; i < equipes.size(); i++) {
			posicao = equipes.get(i).getPosicao();
			equipe = equipes.get(i).getEquipe();
			pontuacao = equipes.get(i).getPontuacao();
			texto += posicao + "\t"  + equipe + "\t" + pontuacao + ".\n";
		}

		return texto;
	}

}