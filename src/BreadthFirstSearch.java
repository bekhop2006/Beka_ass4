import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();

    public BreadthFirstSearch(Vertex<V> start) {
        super(start);
        bfs(start);
    }

    private void bfs(Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    edgeTo.put(neighbor, current);
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> end) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = end; x != null; x = edgeTo.get(x)) {
            path.add(0, x);
        }
        return path;
    }
}
