package tda;

// Implémentation d'une liste statique
public class Liste<T> extends AbstractTDAStatique<T> implements IListe<T> {
    
	public Liste(int capacite) {
        super(capacite);
    }

    public void ajouter(T element, int index) {
        if (estPleine()) {
            agrandirTableau();
        }
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Index invalide");
        }
        for (int i = nbElements; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        nbElements++;
    }

    public T enlever(int index) {
        if (index < 0 || index >= nbElements) {
            throw new IndexOutOfBoundsException("Index invalide");
        }
        T element = elements[index];
        for (int i = index; i < nbElements - 1; i++) {
            elements[i] = elements[i + 1];
        }
        nbElements--;
        return element;
    }

    public T obtenir(int index) {
        if (index < 0 || index >= nbElements) {
            throw new IndexOutOfBoundsException("Index invalide");
        }
        return elements[index];
    }
}
