package jvreis.webscrapingf1;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;//importando biblioteca Jsoup
import org.jsoup.nodes.Document;//importado ao criar vari�vel "documento"
import org.jsoup.nodes.Element;//importado ao criar vari�vel "elemento"
import org.jsoup.select.Elements;

//Obs.: Comando Alt+Shift+s -> "Generate Getters and Setters" gera automaticamente as fun��es 
//get e set para cada vari�vel
public class Scrap {// classe que cont�m os dados HTML
	static String texto = "## By JvReis\n";

	// fun��o para buscar no site. Cria uma c�pia HTML da URL e buscar� elementos
	// pela classe dada
	// imprimir� os dados e retornar� uma string texto para escrita em arquivo
	public static List<Piloto> search() {// retorna uma lista de descrição dos times (olhar classe time)
		// 1 - URL do site a ser acessado
		String link = ("https://ge.globo.com/motor/formula-1/noticia/f1-2021-confira-a-classificacao-de-pilotos-e-equipes.ghtml");// link
																																	// para
																																	// o
																																	// WebScraping
		Document documento = null;
		// System.out.println(link);// testando impressão do link
		try {
			// 2 - Conectando e obtendo uma cópia do html inteiro da página
			documento = Jsoup.connect(link).get();// usando biblioteca Jsoup apra se conectar ao link
			// System.out.println("Requisição realizada com sucesso!");
		} catch (Exception e) {
			System.out.println("Site Indisponível ou falha na requisição!");
		}
		// Elementos são um array e o .getElementsByClass pegará os elementos com a
		// classe informada

		// 3 - Obtendo a tabela através de sua classe
		Element table_1 = documento.getElementsByClass("show-table__container").first(); // precisa do .first no final
																							// senão tem que declarar
																							// table_1 como Elements e
																							// não Element
		// essa classe acima é a div class que no caso pega a tabela toda. Neste caso
		// não foi utilizado a table class

		// 4 - Obtendo o corpo da tabela através da tag
		Element tbody_1 = table_1.getElementsByTag("tbody").first();

		// 5 - Criando uma lista de todos os tr's do tbody obtido
		List<Element> pilotos = tbody_1.getElementsByTag("tr");

		// 6 - Criando uma lista vazia para Guardar os dados dos tr's convertidos
		List<Piloto> piloto_descricao = new ArrayList<>();// lista de objetos piloto. cada entrada terá um objeto piloto
															// com suas respectivas descrições

		// 7 - Iterando por cada tr e convertendo-o em um Piloto. Em seguida inserindo-o
		// na lista de Pilotos
		for (Element piloto : pilotos) {//para cada elemento
			// Listando todos os atributos do tr em questão
			List<Element> descricao = piloto.getElementsByTag("td");// pegando elemento pela tag
			// criando o objeto e inserindo nele os atributos extraidos do td
			Piloto x = new Piloto();
			x.setPosicao(descricao.get(0).text());
			x.setPiloto(descricao.get(1).text());
			x.setPais(descricao.get(2).text());
			x.setEquipe(descricao.get(3).text());
			x.setPontuacao(descricao.get(4).text());
			// adicionando o objeto na lista de objetos de Pilotos
			piloto_descricao.add(x);
		}
		return piloto_descricao;
	}
}
