package modele.tda;

import java.util.Objects;

public class ListeStatique<T> {

    private final T[] elements;
    private int taille;

    @SuppressWarnings("unchecked")
    public ListeStatique(int capacite){
        if (capacite <= 0) throw new IllegalArgumentException("capacite > 0 requise");
        this.elements = (T[]) new Object[capacite];
        this.taille = 0;
    }

    public ListeStatique() {
        this(10_000); // ajuster si besoin
    }

    public void ajouter(T element){
        if (taille < elements.length){
            elements[taille++] = element;
        } else {
            throw new IllegalStateException("Liste pleine");
        }
    }

    public void enlever(T element){
        for(int i = 0; i < taille; i++){
            if(Objects.equals(elements[i], element)){
                for(int j = i; j < taille - 1; j++){
                    elements[j] = elements[j + 1];
                }
                elements[--taille] = null;
                return;
            }
        }
    }

    public int getTaille(){
        return taille;
    }

    public boolean estPleine() {
        return taille == elements.length;
    }

    public boolean estVide() {
        return taille == 0;
    }

    public T get(int index){
        if (index < 0 || index >= taille)
            throw new IndexOutOfBoundsException("index=" + index + ", taille=" + taille);
        return elements[index];
    }
}
