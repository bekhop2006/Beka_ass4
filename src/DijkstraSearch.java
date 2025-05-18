import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distances = new HashMap<>();
    private final Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

    public DijkstraSearch(Vertex<V> start) {
        super(start);
        dijkstra(start);
    }

    private void dijkstra(Vertex<V> start) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        distances.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double distanceThroughCurrent = distances.get(current) + weight;
                if (distanceThroughCurrent < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, distanceThroughCurrent);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> end) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = end; at != null; at = previous.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
