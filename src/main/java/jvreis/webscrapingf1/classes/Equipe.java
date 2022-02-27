<<<<<<<< HEAD:src/main/java/jvreis/webscrapingf1/classes/Equipe.java
package jvreis.webscrapingf1.classes;
========
package jvreis.webscrapingf1class;
>>>>>>>> 552192996d60e75796d3dc75ac9b775ddb693d8d:src/main/java/jvreis/webscrapingf1/webscrapingf1class/Equipe.java

public class Equipe{

    private String posicao;
    private String equipe;
    private String pontuacao;


    public Equipe(String posicao, String equipe, String pontuacao) {
    	this.posicao = posicao;
        this.equipe = equipe;
        this.pontuacao = pontuacao;
    }
    

	public Equipe() {
    	
    }

    
    public String getPosicao() {
		return posicao;
	}


	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}


	public String getEquipe() {
		return equipe;
	}


	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}


	public String getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}







    
}