package modele.reseau;

import modele.communication.Message;
import modele.physique.Carte;
import modele.physique.ObjetMobile;
import modele.physique.Position;
import modele.tda.ListeStatique;

import java.util.Random;

public class Cellulaire extends ObjetMobile implements UniteCellulaire {

    private static final int NON_CONNECTE = -1;
    private static final double PROB_APPELER = 0.05;
    private static final double PROB_ENVOI_MSG = 0.02;
    private static final double PROB_DECONNEXION = 0.1;

    private String numeroLocal;
    private int numConnexion = NON_CONNECTE;
    private String numeroConnecte = null;
    private Antenne antenneConnecte;

    private Antenne antenneConnectee;
    private Random r = new Random();
    private ListeStatique<Antenne> antennes;
    private ListeStatique<Cellulaire> cellulaires;
    private Reseau reseau;

    public Cellulaire(String numeroLocal, Position position, double vitesse, double deviationStandard) {
        super(position, vitesse, deviationStandard);
        this.numeroLocal = numeroLocal;
        this.r = new Random();
        this.reseau = Reseau.getInstance();
        this.antenneConnectee = reseau.antenneLaPlusProche(getPosition()); // init

    }

    public boolean estConnecte() {
        return this.numConnexion != NON_CONNECTE;
    }

    public int getNumConnexion() {
        return numConnexion;
    }

    public boolean comparerNumero(String numero) {
        return this.numeroLocal.equals(numero);
    }

    @Override
    public String toString() {
        return "" + numeroLocal + " " + getPosition();
    }

    @Override
    public int appeler(String numeroAppele, String numeroAppelant, Antenne antenne) {
        return 0;
    }

    @Override
    public Cellulaire repondre(String numeroAppele, String numeroAppelant, int numConnexion) {
        return null;
    }

    @Override
    public void finAppelLocal(String numeroAppele, int numConnexion) {

    }

    @Override
    public void finAppelDistant(String numeroAppele, int numConnexion) {

    }

    @Override
    public void envoyer(Message message, int numConnexion) {

    }

    @Override
    public void recevoir(Message message) {

    }

    public void effectuerTour() {
        seDeplacer();

        Carte.ajusterPosition(getPosition());

        Antenne nouvelle = reseau.antenneLaPlusProche(getPosition());

        if (nouvelle != antenneConnecte) {
            antenneConnecte = nouvelle;
        }
    }
}

