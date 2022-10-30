package algorithms;

import java.util.*;

public class BidirectionalSearch {

    private final String start;
    private final String destination;
    private final HashMap<String, ArrayList<String>> graph;

    public Set<String> vStart;
    public Set<String> vDest;

    public BidirectionalSearch(String start, String destination, HashMap<String, ArrayList<String>> graph) {
        this.start = start;
        this.destination = destination;
        this.graph = graph;
    }

    public int find() {
        Queue<String> qStart = new LinkedList<>();
        Queue<String> qDest = new LinkedList<>();

        vStart = new HashSet<>();
        vDest = new HashSet<>();

        int startStep = 0;
        int destStep = 0;

        qStart.add(start);
        vStart.add(start);

        qDest.add(destination);
        vDest.add(destination);


        while (!qStart.isEmpty() && !qDest.isEmpty()) {

            int startSize = qStart.size();
            int destSize = qDest.size();

            for (int i = 0; i < startSize; i++) {
                String curr = qStart.poll();
                assert curr != null;
                if (curr.equals(destination)) return startStep;
                if (vDest.contains(curr)) return startStep + destStep;
                for (String node : graph.get(curr)) {
                    qStart.add(node);
                    vStart.add(node);
                }
            }
            startStep++;

            for (int i = 0; i < destSize; i++) {
                String curr = qDest.poll();
                assert curr != null;
                if (curr.equals(start)) return destStep;
                if (vStart.contains(curr)) return destStep + startStep;
                for (String node : graph.get(curr)) {
                    qDest.add(node);
                    vDest.add(node);
                }
            }
            destStep++;
        }
        return startStep + destStep;
    }



}