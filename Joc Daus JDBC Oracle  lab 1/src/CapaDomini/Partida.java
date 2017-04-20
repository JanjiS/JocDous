package CapaDomini;

public class Partida {

    private int dau1, dau2;

    public Partida() {
        dau1 = dau2 = 0;
    }

    public Partida(int d1, int d2) {
        dau1 = d1;
        dau2 = d2;
    }

    public boolean getGuanyada() {
        return dau1 + dau2 == 7;
    }

    @Override
    public String toString() {
        String resultat;

        if (getGuanyada()) {
            resultat = "guanyada";
        } else {
            resultat = "perduda";
        }
        return "Dau1: " + dau1 + ", Dau2: " + dau2 + ", Resultat: " + resultat;
    }

    public int getDau1() {
        return dau1;
    }
    
    public int getDau2() {
        return dau2;
    }
}
