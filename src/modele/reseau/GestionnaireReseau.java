package modele.reseau;

/**
 * Le gestionnaire r�seau est responsable de g�rer les connexions cellulaires et de relayer
 * les appels, messages et fin d'appel.
 * 
 * Dans le cadre de la simulation, c'est �galement le gestionnaire r�seau qui instancie Antennes et
 * cellulaire et qui g�re l'ex�cution par tour des cellulaires.
 * 
 * Le gestionnaire r�seau est un singleton
 * 
 * @author Fred Simard
 * @version Hiver 2021
 */


import modele.communication.Connexion;
import modele.gestionnaires.GestionnaireScenario;
import modele.physique.Position;
import observer.MonObservable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class GestionnaireReseau extends MonObservable implements Runnable {

    public static final int PERIODE_SIMULATION_MS = 100;
    public static final double VITESSE = 10.0;
    public static final double DEVIATION_STANDARD = 0.05;
    public static final int NB_CELLULAIRES = 30;
    public static final int NB_ANTENNES = 10;
    public static final int CODE_NON_CONNECTE = -1;

    private boolean mondeEnVie = true;
    private static final GestionnaireReseau instance = new GestionnaireReseau();

    private final Random random = new Random();
    private final Collection<Antenne> antennes = new ArrayList<>();
    private final Collection<Cellulaire> cellulaires = new ArrayList<>();
    private final List<Connexion> connexions = new ArrayList<>();

	/**
	 * m�thode permettant d'obtenir une r�f�rence sur le Gestionnaire R�seau
	 * @return instance
	 */
	public static GestionnaireReseau getInstance() {
		return instance;
	}
	
	private GestionnaireReseau() {

    }

	/**
	 * permet de mettre fin � la simulation
	 * @param mondeEnVie
	 */
	public void finDeSimulation() {
		this.mondeEnVie = false;
	}

    public Collection<Antenne> getAntennes() {
        return antennes;
    }

    public Collection<Cellulaire> getCellulaires() {
        return cellulaires;
    }

    private void creeAntennes() {
        for (int i = 0; i < NB_ANTENNES; i++) {
            double x = random.nextDouble() * 100.0;
            double y = random.nextDouble() * 100.0;
            Position pos = new Position(x, y);
            Antenne antenne = new Antenne(pos);
            antennes.add(antenne);
        }
    }

    private void creeCellulaires() {
        for (int i = 0; i < NB_CELLULAIRES; i++) {
            String numero = GestionnaireScenario.obtenirNouveauNumeroStandard();
            double x = random.nextDouble() * 100.0;
            double y = random.nextDouble() * 100.0;
            Position pos = new Position(x, y);
            Cellulaire cell = new Cellulaire(numero, pos, VITESSE, DEVIATION_STANDARD);
            cellulaires.add(cell);
        }
    }


	/**
	 * s'ex�cute en continue pour simuler le syst�me
	 */
	@Override
	public void run() {


		creeAntennes();
		creeCellulaires();
		this.avertirLesObservers();

		while(this.mondeEnVie) {

			for(Cellulaire cell : cellulaires) {
				//cell.effectuerTour();
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
