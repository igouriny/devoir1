package tda;

// Interface pour une file (FIFO)
public interface IFile<T> {
    void enfiler(T element);
    T defiler();
}