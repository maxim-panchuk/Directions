package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {

    public final String start;
    public final String destination;
    private final HashMap<String, ArrayList<String>> graph;
    public Set<String> visited;
    private int ans = 0;

    public DepthFirstSearch(String start, String destination, HashMap<String, ArrayList<String>> graph) {
        this.start = start;
        this.destination = destination;
        this.graph = graph;
        this.visited = new HashSet<>();
    }

    public void find() {
        findPath(start, destination, visited, 0);
    }

    private boolean findPath(String curr, String target, Set<String> visited, int step) {
        if (curr.equals(target)) {
            ans = step;
            return true;
        }
        for (String node : graph.get(curr)) {
            if (!visited.contains(node)) {
                visited.add(node);
                if (findPath(node, target, visited, step + 1)) return true;
            }
        }
        return false;
    }

    public int getAns() {
        return ans;
    }

}
