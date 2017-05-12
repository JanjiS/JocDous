package CapaAplicacio;

import java.util.ArrayList;
import java.util.List;

import CapaAplicacio.DTO.JugadorDTO;
import CapaAplicacio.DTO.PartidaDTO;
import CapaDomini.Dau;
import CapaDomini.Jugador;
import CapaDomini.Partida;
import CapaPersistencia.JugadorBBDD;
import CapaPersistencia.PartidaBBDD;

public class ControladorJocDaus {

    private Dau dau1, dau2;
    private final int CARES_DAUS = 6;
    private Jugador jugador;
    private Partida partidaActual;
    
    public ControladorJocDaus() {
        dau1 = new Dau(CARES_DAUS);
        dau2 = new Dau(CARES_DAUS);
        jugador = new Jugador("Anonim");  
    }
    
    public void jugar() {
        int tirada1 = this.tirarDau(dau1);
        int tirada2 = this.tirarDau(dau2);
        partidaActual = new Partida(tirada1, tirada2);
        try {
			PartidaBBDD.storePartida(partidaActual, jugador);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    private int tirarDau(Dau dau) {
        dau.llenca();
        return dau.valorCara();
    }

    public String getNomJugador() {
        return jugador.getNom();
    }

    public PartidaDTO PartidaEnCurs() {
        return new PartidaDTO(partidaActual);
    }
    
    public JugadorDTO getJugadorDTO(){
    	return new JugadorDTO(jugador);
    }

    public double guanyadesPercent() throws Exception {
    	int guanyades = 0;
       	for (Partida p: PartidaBBDD.getPartides(jugador.getNom())) {
			if(p.getGuanyada()) guanyades++;
		}
        return guanyades / (float) PartidaBBDD.getPartides(jugador.getNom()).size() * 100;
    }

    public void nouJugador(String nom) {
        //Si el nom és "Anonim" no cal fer res
        if (!nom.equalsIgnoreCase("Anonim")) {          
            try {
				jugador = JugadorBBDD.getJugador(nom);
			} catch (Exception e) {
				jugador = new Jugador(nom);
				try {
					JugadorBBDD.createJugador(jugador);
				} catch (Exception e1) {
					System.out.println("Error al crear nou jugador");
				}
			}         
        }
    }

    public String getPartides() throws Exception {
        List<Partida> partides = PartidaBBDD.getPartides(jugador.getNom());
       
        String result = "" ;
        
        
        for(Partida p:partides){
        	result+=new PartidaDTO(p).getResultat()+"\n";
        	System.out.println(result);
        }
        System.out.println(result);
        return result;
    }   	
}
