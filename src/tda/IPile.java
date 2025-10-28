package tda;

// Interface pour une pile (LIFO)
public interface IPile<T> {
    void empiler(T element);
    T depiler();
}