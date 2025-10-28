package modele.reseau;

import modele.communication.Message;
import modele.physique.ObjetPhysique;
import modele.physique.Position;
import modele.tda.ListeStatique;

import java.util.List;

public class Antenne extends ObjetPhysique implements UniteCellulaire {


    private Reseau reseau;
    private ListeStatique<Cellulaire> cellulaires;


    public Antenne(Position position) {
        super(position);
        this.reseau = Reseau.getInstance();
        this.cellulaires = new ListeStatique<>(50);
    }


    public void ajouterCellulaire(Cellulaire c) {
        cellulaires.ajouter(c);
    }

    public void enleverCellulaire(Cellulaire c) {
        cellulaires.enlever(c);
    }

    public double distance(Position autre) {
        return this.getPosition().distance(autre);
    }

    @Override
    public String toString(){
        return "Antenne  la position " + getPosition().toString();
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
}
