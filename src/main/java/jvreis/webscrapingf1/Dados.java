package jvreis.webscrapingf1;

import java.util.List;

public class Dados {
	List<Piloto> pilotos;
	List<Equipe> equipes;
	
	
    public Dados(List<Piloto> pilotos, List<Equipe> equipes) {
    	this.pilotos = pilotos;
        this.equipes = equipes;

    }
    

	public Dados() {
    	
    }
	
	public List<Piloto> getPilotos() {
		return pilotos;
	}
	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
}
