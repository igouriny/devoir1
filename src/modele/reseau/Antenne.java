package modele.reseau;

import modele.communication.Message;
import modele.physique.ObjetPhysique;
import modele.physique.Position;

import java.util.ArrayList;
import java.util.List;

public class Antenne extends ObjetPhysique implements UniteCellulaire {

    private GestionnaireReseau gestionnaireReseau;
    private static final List<Cellulaire> listeCellulaires = new ArrayList<>();

    public Antenne(Position position) {
        super(position);
        gestionnaireReseau = GestionnaireReseau.getInstance();
    }

    public static List<Cellulaire> getListeCellulaires() {
        return listeCellulaires;
    }

    public GestionnaireReseau getGestionnaireReseau() {
        return gestionnaireReseau;
    }

    public double distance(Position autre){
        return getPosition().distanceEntre(autre);
    }

    @Override
    public String toString() {
        return "Antenne { position=" + getPosition() + " }";
    }

    @Override
    public int appeler(String numeroAppele, String numeroAppelant, Antenne antenneConnectee) {
        return 0;
    }

    @Override
    public Cellulaire repondre(String numeroAppele, String numeroAppelant, int numeroConnexion) {
        return null;
    }

    @Override
    public void finAppelLocal(String numeroAppele, int numeroConnexion) {

    }

    @Override
    public void finAppelDistant(String numeroAppele, int numeroConnexion) {

    }

    @Override
    public void envoyer(Message message, int numeroConnexion) {

    }

    @Override
    public void recevoir(Message message) {

    }
}
