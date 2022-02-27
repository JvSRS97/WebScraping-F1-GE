package jvreis.webscrapingf1.classes;

public class Piloto{

    public String posicao;
    public String piloto;
    public String pais;
    public String equipe;
    public String pontuacao;


    public Piloto(String posicao, String piloto, String pais, String equipe, String pontuacao) {
    	this.posicao = posicao;
        this.piloto = piloto;
        this.pais = pais;
        this.equipe = equipe;
        this.pontuacao = pontuacao;
    }

    
    public Piloto() {
    	
    }


	public String getPosicao() {
		return posicao;
	}


	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}


	public String getPiloto() {
		return piloto;
	}


	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
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