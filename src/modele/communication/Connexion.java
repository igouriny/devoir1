package modele.communication;

import modele.reseau.Antenne;

public class Connexion {

    private static final int NB_ANTENNES = 2;

    private int numeroConnexion = 0;
    private Antenne[] antennes;

    public Connexion(int numeroConnexion, Antenne antenne, Antenne autreAntenne) {
        this.numeroConnexion = numeroConnexion;
        this.antennes = new Antenne[NB_ANTENNES];
        this.antennes[0] = antenne;
        this.antennes[1] = autreAntenne;
    }

    public int getNumeroConnexion(){
        return numeroConnexion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Connexion autre = (Connexion) obj;
        return this.numeroConnexion == autre.numeroConnexion;
    }

    @Override
    public String toString() {
        return "Connexion #" + numeroConnexion +
                " entre " + antennes[0] + " et " + antennes[1];
    }
}
