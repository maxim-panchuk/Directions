package algorithms;

import java.util.*;

public class BreadthFirstSearch {

    private final String start;
    private final String destination;
    private final HashMap<String, ArrayList<String>> graph;

    public Set<String> visited;

    public BreadthFirstSearch(String start, String destination, HashMap<String, ArrayList<String>> graph) {
        this.start = start;
        this.destination = destination;
        this.graph = graph;
    }

    public int find() {
        Queue<String> queue = new LinkedList<>();
        visited = new HashSet<>();

        int step = 0;
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                assert curr != null;
                if (curr.equals(destination)) return step;
                for (String node : graph.get(curr)) {
                    if (!visited.contains(node)) {
                        queue.add(node);
                        visited.add(node);
                    }
                }
            }
            step++;
        }
        return step;
    }

}
