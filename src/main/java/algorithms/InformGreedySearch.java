package algorithms;

import model.Adjacency;

import java.util.*;

public class InformGreedySearch {

    private final String start;
    private final String destination;
    public Set<String> visited;
    private final HashMap<String, ArrayList<String>> graph;
    private final HashMap<String, Integer> distances;
    private final List<Adjacency> refs;
    private int ans = 0;

    public InformGreedySearch(String start, String destination, HashMap<String,
            ArrayList<String>> graph, HashMap<String, Integer> distances, List<Adjacency> refs) {
        this.start = start;
        this.destination = destination;
        this.graph = graph;
        this.visited = new HashSet<>();
        this.distances = distances;
        this.refs = refs;
    }

    public int find() {
        if (findPath(start, destination, 0, visited)) return ans;
        return 0;
    }

    private boolean findPath(String curr, String target, int distance, Set<String> visited) {
        if (curr.equals(target)) {
            ans = distance;
            return true;
        }

        int minDistance = Integer.MAX_VALUE;
        String nodeToJump = null;

        for (String node : graph.get(curr)) {
            // Если город в который можно прыгнуть не был ранее посещен.
            if (!visited.contains(node)) {
                // То найдем из таблицы прямых дистанций тот, расстояние до цели от которого минимальное.
                int currDistance = distances.get(node);
                if (minDistance > currDistance) {
                    minDistance = currDistance;
                    nodeToJump = node;
                }
            }
        }
        // Если все ноды уже посещали - делаем бэктрэк
        if (nodeToJump == null) return false;

        // Теперь ищем расстояние от текущего города до выбранного, чтобы считать реальное расстояние.
        int dst = 0;
        for (Adjacency item : refs) {
            if (item.connected(curr, nodeToJump)) {
                dst = item.getDistance();
                break;
            }
        }
        return findPath(nodeToJump, target, distance + dst, visited);
    }
}
