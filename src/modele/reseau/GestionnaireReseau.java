package modele.reseau;

/**
 * Le gestionnaire réseau est responsable de gérer les connexions cellulaires et de relayer
 * les appels, messages et fin d'appel.
 * <p>
 * Dans le cadre de la simulation, c'est également le gestionnaire réseau qui instancie Antennes et
 * cellulaire et qui gère l'exécution par tour des cellulaires.
 * <p>
 * Le gestionnaire réseau est un singleton
 *
 * @author Fred Simard
 * @version Hiver 2021
 */


import modele.communication.Connexion;
import modele.gestionnaires.GestionnaireScenario;
import modele.physique.Carte;
import modele.physique.Position;
import observer.MonObservable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GestionnaireReseau extends MonObservable implements Runnable {
    private final int PERIODE_SIMULATION_MS = 100;
    private final double VITESSE = 10.0;
    private final double DEVIATION_STANDARD = 0.05;
    public static final int NB_CELLULAIRES = 30;
    public static final int NB_CRIMINELS = 3;
    private final int NB_ANTENNES = 10;
    private final int CODE_NON_CONNECTE = -1;

    private Random random = new Random();
    private ArrayList<Antenne> antennes = new ArrayList<>();
    private ArrayList<Cellulaire> cellulaires = new ArrayList<>();
    private tda.Liste<Connexion> connexions = new tda.Liste<>(0);

    private boolean mondeEnVie = true;
    private static GestionnaireReseau instance = new GestionnaireReseau();

    private Connexion chercherConnexion(int numero) {
        // TODO recherche binaire
        for (int i = 0; i < connexions.getNbElements(); i++) {
            if (connexions.obtenir(i).getNumeroConnexion() == numero) {
                return connexions.obtenir(i);
            }
        }
        return null;
    }

    public void ajouterConnexion(Connexion connexion) {
        int numeroConnexion = connexion.getNumeroConnexion();

        if (connexions.getNbElements() == 0 || connexions.obtenir(0).getNumeroConnexion() > numeroConnexion) {
            connexions.ajouter(connexion, 0);
            return;
        }

        int position = 0;
        for (int i = 0; i < connexions.getNbElements(); i++) {
            if (connexions.obtenir(i).getNumeroConnexion() > numeroConnexion) {
                position = i;
                break;
            }
            position = i + 1;
        }

        connexions.ajouter(connexion, position);
    }

    private void creeAntennes() {
        for (int i = 0; i < NB_ANTENNES; i++) {
            Antenne antenne = new Antenne(Carte.genererPositionAlea());
            antennes.add(antenne);
        }
    }

    private void creeCellulaires() {
        for (int i = 0; i < NB_CELLULAIRES; i++) {
            Cellulaire cellulaire = new Cellulaire(
                    Carte.genererPositionAlea(),
                    random.nextInt(),
                    random.nextDouble(),
                    GestionnaireScenario.obtenirNouveauNumeroStandard()
            );
            cellulaires.add(cellulaire);
        }
    }

    public ArrayList<Antenne> getAntennes() {
        return antennes;
    }

    public ArrayList<Cellulaire> getCellulaires() {
        return cellulaires;
    }

    /**
     * méthode permettant d'obtenir une référence sur le Gestionnaire Réseau
     *
     * @return instance
     */
    public static GestionnaireReseau getInstance() {
        return instance;
    }

    private GestionnaireReseau() {
    }

    /**
     * permet de mettre fin à la simulation
     *
     * @param mondeEnVie
     */
    public void finDeSimulation() {
        this.mondeEnVie = false;
    }

    /**
     * s'exécute en continue pour simuler le système
     */
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
