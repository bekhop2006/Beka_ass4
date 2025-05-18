import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> map = new HashMap<>();

    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);
        map.get(source).add(new Edge<>(source, destination, weight));
    }

    public Map<Vertex<V>, List<Edge<Vertex<V>>>> getGraph() {
        return map;
    }

    public Set<Vertex<V>> getVertices() {
        return map.keySet();
    }
}
