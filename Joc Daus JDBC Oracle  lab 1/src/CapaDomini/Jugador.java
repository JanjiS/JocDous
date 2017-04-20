package CapaDomini;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nom;
    private Partida darreraPartida;
    private ArrayList<Partida> partides;
    private int guanyades = 0;
     private int numPartidesPersistents;


    public Jugador(String nom) {
        this.nom = nom;
        guanyades = 0;
        partides = new ArrayList<Partida>();

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String resultatPartides() {
        String resultat = "";
        for (Partida p : partides) {
            resultat += p + "\n";
        }
        return resultat;
    }

    public void addPartida(int dau1, int dau2) {
        darreraPartida = new Partida(dau1, dau2);
        this.desarDarreraPartida();
        this.actualitzarGuanyades();
    }

    public String resultatPartidaEnCurs() {
        return darreraPartida.toString();
    }

    public boolean guanyadaDarreraPartida() {
        return darreraPartida.getGuanyada();
    }

    public int nombrePartides() {
        return partides.size();
    }

    public int nombreGuanyades() {
        return guanyades;
    }

    private void desarDarreraPartida() {
        partides.add(darreraPartida);
    }

    private void actualitzarGuanyades() {
        guanyades += darreraPartida.getGuanyada() ? 1 : 0;
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
