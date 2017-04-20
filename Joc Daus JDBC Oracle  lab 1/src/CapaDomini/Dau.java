package CapaDomini;

public class Dau {

    private int nombreCares;
    private int cara = 0;

    public Dau(int cares) {
        nombreCares = cares;
    }

    public void llenca() {
        double aleat = java.lang.Math.random() * nombreCares;
        cara = (int) java.lang.Math.ceil(aleat);
    }

    public int valorCara() {
        return cara;
    }
}
