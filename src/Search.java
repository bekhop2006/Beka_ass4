import java.util.List;

public abstract class Search<V> {
    protected final Vertex<V> start;

    public Search(Vertex<V> start) {
        this.start = start;
    }

    public abstract List<Vertex<V>> getPath(Vertex<V> end);
}
