package tda;

// Implémentation d'une pile statique
public class Pile<T> extends AbstractTDAStatique<T> implements IPile<T> {
    
	public Pile(int capacite) {
        super(capacite);
    }

    public void empiler(T element) {
    	
        if (estPleine()) {
        	agrandirTableau();
        }
        
        elements[nbElements++] = element;
    }

    public T depiler() {
    	
        if (estVide()) {
            throw new IllegalStateException("Pile vide");
        }
        
        nbElements--;
        
        return elements[nbElements];
    }

}