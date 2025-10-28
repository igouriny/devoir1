package modele.reseau;

import modele.communication.Message;

public interface UniteCellulaire {

    public int appeler(String numeroAppele, String numeroAppelant, Antenne antenne);
    public Cellulaire repondre(String numeroAppele, String numeroAppelant, int numConnexion);
    public void finAppelLocal(String numeroAppele, int numConnexion);
    public void finAppelDistant(String numeroAppele, int numConnexion);
    public void envoyer(Message message, int numConnexion);
    public void recevoir(Message message);
}
