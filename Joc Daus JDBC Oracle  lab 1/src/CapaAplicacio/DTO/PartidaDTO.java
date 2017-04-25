package CapaAplicacio.DTO;

import CapaDomini.Partida;

public class PartidaDTO {
	
	private int dau1, dau2;
	
	public PartidaDTO (Partida p){
		this.dau1=p.getDau1();
		this.dau2=p.getDau2();
	}
}
