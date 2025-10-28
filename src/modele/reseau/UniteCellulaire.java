package modele.reseau;

import modele.communication.Message;

public interface UniteCellulaire {
    int appeler(String numeroAppele, String numeroAppelant, Antenne antenneConnecte);

    Cellulaire repondre(String numeroAppele, String numeroAppelant, int connexion);

    void finAppelLocal(String numeroAppele, int connexion);

    void finAppelDistant(String numeroAppele, int connexion);

    void envoyer(Message message, int connexion);

    void recevoir(Message message);
}
