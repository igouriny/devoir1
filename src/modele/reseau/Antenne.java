package modele.reseau;

import modele.communication.Message;
import modele.physique.ObjetPhysique;
import modele.physique.Position;

import java.util.ArrayList;

public class Antenne extends ObjetPhysique implements UniteCellulaire {
    private GestionnaireReseau gestionnaireReseau = GestionnaireReseau.getInstance();
    private ArrayList<Cellulaire> cellulaires = new ArrayList<>();

    public Antenne(Position position) {
        super(position);
    }

    // TODO
    @Override
    public int appeler(String numeroAppele, String numeroAppelant, Antenne antenneConnecte) {
        return 0;
    }

    // TODO
    @Override
    public Cellulaire repondre(String numeroAppele, String numeroAppelant, int connexion) {
        return new Cellulaire(new Position(2.2,3.4), 2, 2.3, "");
    }

    // TODO
    @Override
    public void finAppelLocal(String numeroAppele, int connexion) {

    }

    // TODO
    @Override
    public void finAppelDistant(String numeroAppele, int connexion) {

    }

    // TODO
    @Override
    public void envoyer(Message message, int connexion) {

    }

    // TODO
    @Override
    public void recevoir(Message message) {

    }

    public double distance(Position position) {
        return getPosition().distance(position);
    }

    public String toString() {
        return getPosition().toString();
    }
}
