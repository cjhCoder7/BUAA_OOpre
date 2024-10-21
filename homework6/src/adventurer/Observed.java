package adventurer;

public interface Observed {
    public void registerObserver(Watcher o);

    public void notifyObservers();
}
