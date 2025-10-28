package modele.reseau;

import modele.communication.Connexion;
import modele.physique.Carte;
import modele.physique.Position;
import modele.tda.ListeOrdonnee;
import observer.MonObservable;

import java.util.ArrayList;
import java.util.Random;

public class Reseau extends MonObservable implements Runnable{


    private boolean mondeEnVie = true;
    private static Reseau instance = new Reseau();


    public static final int PERIODE_SIMULATION_MS = 100;
    public static final double VITESSE = 10.0;
    public static final double DEVIATION_STANDARD = 0.05;
    public static final int NB_CELLULAIRES = 30;
    public static final int NB_CRIMINELS = 10;
    public static final int NB_ANTENNES = 10;
    public static final int CODE_NON_CONNECTE = -1;

    private final Random random = new Random();

    private ArrayList<Antenne> antennes;
    private ArrayList<Cellulaire> cellulaires;

    ListeOrdonnee<Connexion> connexions =
            new ListeOrdonnee<>(200, Connexion::getNumeroConnexion);
    public static Reseau getInstance() {
        return instance;
    }

    private Reseau() {}

    public void finDeSimulation() {
        this.mondeEnVie = false;
    }

    public ArrayList<Antenne> getAntennes() {
        return antennes;
    }

    public ArrayList<Cellulaire> getCellulaires() {
        return cellulaires;
    }

    private void creeAntennes() {
        antennes = new ArrayList<>();
        for (int i = 0; i < NB_ANTENNES; i++) {
            antennes.add(new Antenne(Carte.genererPositionAlea()));
        }
    }

    private void creeCellulaires() {
        cellulaires = new ArrayList<>();
        for (int i = 0; i < NB_CELLULAIRES; i++) {
            String numero = "C" + (i + 1);
            Position p = Carte.genererPositionAlea();
            Cellulaire cell = new Cellulaire(numero, p, VITESSE, DEVIATION_STANDARD);
            cellulaires.add(cell);
        }
    }
    public Antenne antenneLaPlusProche(Position pos) {
        Antenne best = null;
        double bestD = Double.POSITIVE_INFINITY;
        for (Antenne a : antennes) {
            double d = a.distance(pos);
            if (d < bestD) { bestD = d; best = a; }
        }
        return best;
    }

    @Override
    public void run() {

		creeAntennes();
		creeCellulaires();
		this.avertirLesObservers();

		while(this.mondeEnVie) {

			for(Cellulaire cell : cellulaires) {
				cell.effectuerTour();
			}

			this.avertirLesObservers();


			try {
				Thread.sleep(PERIODE_SIMULATION_MS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
}
