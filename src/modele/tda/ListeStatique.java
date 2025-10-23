package modele.tda;

import java.util.Objects;

public class ListeStatique<T> {

    private final T[] elements;
    private int taille;

    @SuppressWarnings("unchecked")
    public ListeStatique(int capacite){
        if (capacite <= 0) throw new IllegalArgumentException("capacit > 0 requise");
        this.elements = (T[]) new Object[capacite];
        this.taille = 0;
    }

    public void ajouter(T element){
        if (taille < elements.length){
            elements[taille++] = element;
        }
    }

    public void enlever(T element){
        for(int i = 0; i < taille; i++){
            if(Objects.equals(elements[i], element)){
                // dcale  gauche  partir de i
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

    public T get(int index){
        if (index < 0 || index >= taille)
            throw new IndexOutOfBoundsException("index=" + index + ", taille=" + taille);
        return elements[index];
    }
}
