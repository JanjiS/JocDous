package CapaAplicacio;

import java.util.ArrayList;
import java.util.List;

import CapaAplicacio.DTO.JugadorDTO;
import CapaAplicacio.DTO.PartidaDTO;
import CapaDomini.Dau;
import CapaDomini.Jugador;
import CapaDomini.Partida;

public class ControladorJocDaus {

    private Dau dau1, dau2;
    private final int CARES_DAUS = 6;
    private Jugador jugador;
 
    public ControladorJocDaus() {
        dau1 = new Dau(CARES_DAUS);
        dau2 = new Dau(CARES_DAUS);
        jugador = new Jugador("Anonim");       
    }

    public void jugar() {
        int tirada1 = this.tirarDau(dau1);
        int tirada2 = this.tirarDau(dau2);
        jugador.addPartida(tirada1, tirada2);
    }

    private int tirarDau(Dau dau) {
        dau.llenca();
        return dau.valorCara();
    }

    public String getNomJugador() {
        return jugador.getNom();
    }

    public PartidaDTO getPartidaEnCurs() {
        return new PartidaDTO(jugador.getPartidaEnCurs());
    }
    
    public JugadorDTO getJugadorDTO(){
    	return new JugadorDTO(jugador);
    }

    public double guanyadesPercent() {
        return jugador.nombreGuanyades() / (float) jugador.nombrePartides() * 100;
    }

    public void nouJugador(String nom) throws Exception {
        //Si el nom és "Anonim" no cal fer res
        if (!nom.equalsIgnoreCase("Anonim")) {          
               jugador = new Jugador(nom);            
        }
    }

    public String getPartides() {
        List<Partida> partides = jugador.getPartides();
        
        String result = "";
        
        for(Partida p:partides){
        	result+=new PartidaDTO(p).getResultat();
        }
        return result;
    }   	
}
