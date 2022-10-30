package io;

import lombok.Getter;
import lombok.Setter;
import model.Adjacency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class GraphBuilder {
    private List<Adjacency> refs;
    private HashMap<String, ArrayList<String>> nodes;

    // Конструктор Графопостроителя
    public GraphBuilder() {
        refs = new ArrayList<>();
        CsvGraphReader csvGraphReader = new CsvGraphReader();
        csvGraphReader.readCsv(this);
        this.buildGraph();
        GraphWriter graphWriter = new GraphWriter(this.nodes);
        graphWriter.writeGraph();
    }

    // Метод постройик Графа
    private void buildGraph() {
        nodes = new HashMap<>();

        String root;
        String child;

        for (Adjacency ref : refs) {
            root = ref.getRoot();
            child = ref.getChild();
            if (root == null || child == null) continue;
            makeRef(root, child);
            makeRef(child, root);
        }
    }

    // Создание связи между обоими городами
    private void makeRef(String root, String child) {
        ArrayList<String> values;

        if (nodes.containsKey(root)) {
            values = nodes.get(root);
        } else {
            values = new ArrayList<>();
        }

        values.add(child);
        nodes.put(root, values);
    }


}
