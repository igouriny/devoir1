package modele.tda;

public class FileSChainee<T> {


    private static class Noeud<T> {
        T valeur;
        Noeud<T> suivant;

        Noeud(T valeur) {
            this.valeur = valeur;
            this.suivant = null;
        }
    }

    private Noeud<T> tete;
    private Noeud<T> queue;
    private int taille;

    public FileSChainee() {
        tete = null;
        queue = null;
        taille = 0;
    }
    public void enfiler(T element) {
        Noeud<T> nouveau = new Noeud<>(element);
        if (estVide()) {
            tete = nouveau;
            queue = nouveau;
        } else {
            queue.suivant = nouveau;
            queue = nouveau;
        }
        taille++;
    }

    public T defiler() {
        if (estVide()) return null;
        T valeur = tete.valeur;
        tete = tete.suivant;
        if (tete == null) queue = null;
        taille--;
        return valeur;
    }

    public T premier() {
        return estVide() ? null : tete.valeur;
    }

    public boolean estVide() {
        return tete == null;
    }

    public int getTaille() {
        return taille;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FileChainee{");
        Noeud<T> courant = tete;
        while (courant != null) {
            sb.append(courant.valeur);
            if (courant.suivant != null) sb.append(" -> ");
            courant = courant.suivant;
        }
        sb.append("}");
        return sb.toString();
    }
}
