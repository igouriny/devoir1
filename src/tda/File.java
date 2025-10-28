package tda;

// Implémentation d'une file statique avec décalage lors du retrait
public class File<T> extends AbstractTDAStatique<T> implements IFile<T> {
    
    public File(int capacite) {
        super(capacite);
    }

    public void enfiler(T element) {
        if (estPleine()) {
            agrandirTableau();
        }
        elements[nbElements] = element;
        nbElements++;
    }

    public T defiler() {
        if (estVide()) {
            throw new IllegalStateException("File vide");
        }
        
        T element = elements[0];
        
        // Décalage des éléments
        for (int i = 1; i < nbElements; i++) {
            elements[i - 1] = elements[i];
        }
        
        elements[nbElements - 1] = null;
        nbElements--;
        
        return element;
    }
}