package observer;


import java.util.ArrayList;

public abstract class MonObservable {

    private final ArrayList<MonObserver> observers = new ArrayList<>();

    public void attacherObserver(MonObserver observer) {
        observers.add(observer);
    }

    public void avertirLesObservers() {
        for (MonObserver observer : observers) {
            observer.avertir();
        }
    }
}

