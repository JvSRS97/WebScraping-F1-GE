package jvreis.webscrapingf1.classes;

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