package modele.tda;

import java.util.function.ToIntFunction;

public class ListeOrdonnee<T> {

    private final T[] elements;
    private final ToIntFunction<T> extracteurCle; // permet dobtenir le numro pour trier
    private int taille;

    @SuppressWarnings("unchecked")
    public ListeOrdonnee(int capaciteMax, ToIntFunction<T> extracteurCle) {
        this.elements = (T[]) new Object[capaciteMax];
        this.extracteurCle = extracteurCle;
        this.taille = 0;
    }

    public boolean ajouter(T element) {
        if (element == null || taille >= elements.length) return false;
        int cle = extracteurCle.applyAsInt(element);
        int pos = positionInsertion(cle);
        for (int j = taille; j > pos; j--) elements[j] = elements[j - 1];
        elements[pos] = element;
        taille++;
        return true;
    }

    public T obtenirParCle(int cle) {
        int g = 0, d = taille - 1;
        while (g <= d) {
            int m = (g + d) >>> 1;
            int val = extracteurCle.applyAsInt(elements[m]);
            if (val == cle) return elements[m];
            if (val < cle) g = m + 1; else d = m - 1;
        }
        return null;
    }

    private int positionInsertion(int cle) {
        int g = 0, d = taille;
        while (g < d) {
            int m = (g + d) >>> 1;
            if (extracteurCle.applyAsInt(elements[m]) < cle) g = m + 1;
            else d = m;
        }
        return g;
    }
}
