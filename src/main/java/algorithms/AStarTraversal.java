package algorithms;

import model.Adjacency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AStarTraversal {

    private final String start;
    private final String destination;
    private final HashMap<String, ArrayList<String>> graph;
    private final HashMap<String, Integer> distances;
    private final List<Adjacency> refs;
    private HashMap<String, Integer> prevRoutes;
    private int ans;

    public AStarTraversal(String start, String destination, HashMap<String, ArrayList<String>> graph,
                          HashMap<String, Integer> distances, List<Adjacency> refs) {
        this.start = start;
        this.destination = destination;
        this.graph = graph;
        this.distances = distances;
        this.refs = refs;
        this.prevRoutes = new HashMap<>();
    }

    public int find() {
        prevRoutes.put("Рига", 1988);
        if (findPath(start, destination, 0, prevRoutes)) return ans;
        return 0;
    }

    public boolean findPath(String curr, String target, int distance
    , HashMap<String, Integer> prevRoutes) {
        if (curr.equals(target)) {
            ans = distance;
            return true;
        }

        HashMap<String, Integer> currMap = makeCurrMap(curr, distance, prevRoutes);

        if (currMap.isEmpty()) return false;

        while (!currMap.isEmpty()) {

            int minFunDistance = Integer.MAX_VALUE;
            String nodeToJump = null;

            for (Map.Entry entry : currMap.entrySet()) {
                int currVal = (int) entry.getValue();
                if (currVal < minFunDistance) {
                    minFunDistance = currVal;
                    nodeToJump = (String) entry.getKey();
                }
            }

            currMap.remove(nodeToJump);

            assert nodeToJump != null;

            if (findPath(nodeToJump, target, distance + toNodeDistance(curr, nodeToJump), prevRoutes)) return true;
        }
        return false;
    }

    private int toNodeDistance(String curr, String nodeToJump) {
        int dst = 0;
        for (Adjacency item : refs) {
            if (item.connected(curr, nodeToJump)) {
                dst = item.getDistance();
                break;
            }
        }
        return dst;
    }

    private HashMap<String, Integer> makeCurrMap(String curr, int distance, HashMap<String, Integer> prevRoutes) {
        HashMap<String, Integer> currMap = new HashMap<>();
        for (String node : graph.get(curr)) {

            // Определим дистанцию по прямой от этого города
            int nodeStraightDistance = distances.get(node);

            // Определим дистанцию до этого города от текущего
            int toNodeDistance = toNodeDistance(curr, node);

            // Определим суммарную стоимость маршрута в этот город;
            int realDistance = toNodeDistance + nodeStraightDistance + distance;

            if (!prevRoutes.containsKey(node)) {
                currMap.put(node, realDistance);
                prevRoutes.put(node, realDistance);
            }
            else {
                int distanceInPrevMap = prevRoutes.get(node);
                if (distanceInPrevMap > realDistance) {
                    currMap.put(node, realDistance);
                    prevRoutes.put(node, realDistance);
                }
            }
        }
        return currMap;
    }

}
