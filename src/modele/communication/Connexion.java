package modele.communication;

import modele.reseau.Antenne;

public class Connexion {

    public static final int NB_ANTENNES = 2;

    private final int numeroConnexion;
    private final Antenne[] antennes = new Antenne[NB_ANTENNES];

    public Connexion(int numeroConnexion, Antenne antenne1, Antenne antenne2) {
        this.numeroConnexion = numeroConnexion;
        this.antennes[0] = antenne1;
        this.antennes[1] = antenne2;
    }

    public int getNumeroConnexion() {
        return numeroConnexion;
    }

    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Connexion connexion = (Connexion) object;
        return numeroConnexion == connexion.numeroConnexion;
    }
}
