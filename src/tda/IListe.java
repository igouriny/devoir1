package tda;

// Interface pour une liste
public interface IListe<T> {
    void ajouter(T element, int index);
    T enlever(int index);
    T obtenir(int index);
}