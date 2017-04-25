package CapaDomini;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nom;
    private Partida darreraPartida; 
    private ArrayList<Partida> partides;
    private int numPartidesPersistents;


    public Jugador(String nom) {
        this.nom = nom;
        partides = new ArrayList<Partida>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addPartida(int dau1, int dau2) {
        darreraPartida = new Partida(dau1, dau2);
        this.desarDarreraPartida();
    }

    public Partida getPartidaEnCurs() {
        return darreraPartida;
    }

    public boolean guanyadaDarreraPartida() {
        return darreraPartida.getGuanyada();
    }

    public int nombrePartides() {
        return partides.size();
    }

    public int nombreGuanyades() {
    	int i=0;
    	for(Partida p:partides){
    		if(p.getGuanyada()) i++;
    	}
        return i;
    }

    private void desarDarreraPartida() {
        partides.add(darreraPartida);
    }

    public List<Partida> getPartides() {
        return partides;
    }

    public int getNumPartidesPersistents() {
       return numPartidesPersistents;
    }

    public void setNumPartidesPersistents(int numPartides) {
       numPartidesPersistents = numPartides;
    }
}
