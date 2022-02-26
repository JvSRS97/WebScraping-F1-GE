package jvreis.webscrapingf1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ScrapingConfiguration {// obs.: editar caminho do arquivo em caso de mudan�a de pasta
	private String path = "C:\\Users\\jvict\\eclipse-workspace\\webscrapingf1\\ScrapingFile.txt";
	private String path_2 = "C:\\Users\\jvict\\eclipse-workspace\\webscrapingf1\\ScrapingFile.xlsx";
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
		List<Piloto> Texto_Arquivo = new ArrayList<>();
		Texto_Arquivo = Scrap.search();// chamando fun��o search da classe Scrap
		imprimir_lista(Texto_Arquivo);
		escreverFile(list_to_txt(Texto_Arquivo), path);// arquivo txt
		// escreverFile(list_to_txt(Texto_Arquivo), path_2);//arquivo xlsx
	}

	private void imprimir_lista(List<Piloto> pilotos) {// imprimindo a lista
		int i;
		String posicao, piloto, pais, equipe, pontuacao;
		System.out.println("\n");
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

	private String list_to_txt(List<Piloto> pilotos) {// convertendo lista em texto numa única variável
		String texto = "## JvReis\n\nPosição\tPiloto\tPaís\tEquipe\tPontuação\n";
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

}