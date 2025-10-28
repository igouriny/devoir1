package tda;

// Classe abstraite de base pour un TDA statique
public abstract class AbstractTDAStatique<T> {
    protected T[] elements;
    protected int nbElements;

    @SuppressWarnings("unchecked")
    public AbstractTDAStatique(int capacite) {
        this.nbElements = 0;
        this.elements = (T[]) new Object[capacite];
    }

    public boolean estVide() {
        return nbElements == 0;
    }

    public boolean estPleine() {
        return nbElements == elements.length;
    }

    public int getNbElements() {
        return nbElements;
    }

    @SuppressWarnings("unchecked")
    public void agrandirTableau() {
    	
        int nouvelleCapacite = elements.length * 2;
        T[] nouveauTableau = (T[]) new Object[nouvelleCapacite];
        System.arraycopy(elements, 0, nouveauTableau, 0, elements.length);
        elements = nouveauTableau;
        
    }
}