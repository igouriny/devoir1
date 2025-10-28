package modele.communication;

import modele.reseau.Antenne;

import java.util.ArrayList;

public class Connexion {
    private final int NB_ANTENNES = 2;

    private int numeroConnexion;
    private ArrayList<Antenne> antennes = new ArrayList<>();

    public Connexion(int numeroConnexion, Antenne antenneX, Antenne antenneY) {
        this.numeroConnexion = numeroConnexion;
        this.antennes.add(antenneX);
        this.antennes.add(antenneY);
    }

    public int getNumeroConnexion() {
        return numeroConnexion;
    }

    public boolean equals(Object obj) {
        try {
            int numero = (int) obj;
            return numeroConnexion == numero;
        } catch (Exception e) {
            return false;
        }
    }
}
