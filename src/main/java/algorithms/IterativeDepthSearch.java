package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class IterativeDepthSearch {

    private final String start;
    private final String destination;
    private final HashMap<String, ArrayList<String>> graph;

    public IterativeDepthSearch(String start, String destination, HashMap<String, ArrayList<String>> graph) {
        this.start = start;
        this.destination = destination;
        this.graph = graph;
    }

    private boolean findPath(String curr, String target, int depth, int limit) {
        if (depth < limit) {
            if (curr.equals(target)) return true;
            for (String node : graph.get(curr)) {
                if (findPath(node, target, depth + 1, limit)) return true;
            }
        }
        return false;
    }

    public int find() {
        int limit = 0;
        while (!findPath(start, destination, 0, limit)) {
            limit++;
        }
        return limit;
    }

}
