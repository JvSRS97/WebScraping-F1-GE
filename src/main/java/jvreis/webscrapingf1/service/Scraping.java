package jvreis.webscrapingf1.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;//importando biblioteca Jsoup
import org.jsoup.nodes.Document;//importado ao criar vari�vel "documento"
import org.jsoup.nodes.Element;//importado ao criar vari�vel "elemento"
import org.jsoup.select.Elements;

import jvreis.webscrapingf1.classes.Dados;
import jvreis.webscrapingf1.classes.Equipe;
import jvreis.webscrapingf1.classes.Piloto;

//Obs.: Comando Alt+Shift+s -> "Generate Getters and Setters" gera automaticamente as fun��es 
//get e set para cada variavel
public class Scraping {// classe que contem os dados HTML
//-------------------------------------------------
	// retorna uma lista de descrição dos pilotos (olhar classe Piloto)
	public static Dados search() {
		Dados dados;
		dados = new Dados();
		
		// 1 - URL do site a ser acessado
		String link = ("https://ge.globo.com/motor/formula-1/noticia/f1-2021-confira-a-classificacao-de-pilotos-e-equipes.ghtml");									// WebScraping
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
		// essa classe abaixo é a div class que no caso pega a tabela toda. Neste caso
		// não foi utilizado a table class
		//Cria uma lista de elementos table da classe dada
		Elements table = documento.getElementsByClass("show-table__container"); 


		// 4 - Obtendo o corpo da tabela através da tag
		//tbody será um elemento da lista de elementos table que possui a tag dada
		Element tbody_p = table.get(0).getElementsByTag("tbody").first();
		Element tbody_e = table.get(1).getElementsByTag("tbody").first();

		// 5 - Criando uma lista de todos os tr's do tbody obtido
		List<Element> pilotos = tbody_p.getElementsByTag("tr");
		List<Element> equipes = tbody_e.getElementsByTag("tr");

		// 6 - Criando uma lista vazia para Guardar os dados dos tr's convertidos
		// lista de objetos piloto. cada entrada terá um objeto piloto com suas respectivas descrições
		// lista de objetos equipe. cada entrada terá um objeto equipe com suas respectivas descrições
		List<Piloto> piloto_descricao = new ArrayList<>();
		List<Equipe> equipe_descricao = new ArrayList<>(); 

		// 7.1 - Iterando por cada tr e convertendo-o em um Piloto. Em seguida inserindo-o na lista de Pilotos
		for (Element piloto : pilotos) {// para cada elemento piloto da lista de elementos pilotos
			
			// Listando todos os atributos do tr em questão
			// pegando elemento pela tag
			List<Element> descricao = piloto.getElementsByTag("td");			
			
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
		//salvando a lista de pilotos na estrutura dados
		dados.pilotos = piloto_descricao;
		
		// 7.2 - Iterando por cada tr e convertendo-o em uma Equipe. Em seguida inserindo-o na lista de Equipes
		for (Element equipe : equipes) {// para cada elemento equipe da lista de elementos equipes
			
			// Listando todos os atributos do tr em questão
			// pegando elemento pela tag
			List<Element> descricao_e = equipe.getElementsByTag("td");
			
			//criando o objeto e inserindo nele os atributos extraidos do td
			Equipe x = new Equipe();
			x.setPosicao(descricao_e.get(0).text());
			x.setEquipe(descricao_e.get(1).text());
			x.setPontuacao(descricao_e.get(2).text());
			
			// adicionando o objeto na lista de objetos de Equipes
			equipe_descricao.add(x);
		}
		//salvando a lista de equipes na estrutura dados
		dados.equipes = equipe_descricao;
		
		return dados;
	}

}
