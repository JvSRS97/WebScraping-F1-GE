<<<<<<<< HEAD:src/main/java/jvreis/webscrapingf1/classes/Dados.java
package jvreis.webscrapingf1.classes;
========
package jvreis.webscrapingf1class;
>>>>>>>> 552192996d60e75796d3dc75ac9b775ddb693d8d:src/main/java/jvreis/webscrapingf1/webscrapingf1class/Dados.java

import java.util.List;

public class Dados {
	public List<Piloto> pilotos;
	public List<Equipe> equipes;
	
	
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
