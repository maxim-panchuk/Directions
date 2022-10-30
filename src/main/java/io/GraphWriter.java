package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphWriter {

    HashMap<String, ArrayList<String>> graph;

    public GraphWriter(HashMap<String, ArrayList<String>> graph) {
        this.graph = graph;
    }

    public void writeGraph() {
        File file = new File("/Users/maksimpancuk/Desktop/SearchDirections/src/main/resources/graphResult.txt");

        try (FileWriter writer = new FileWriter(file)) {
            int line = 1;
            StringBuilder sb;
            for (Map.Entry entry : graph.entrySet()) {
                sb = new StringBuilder();
                sb.append(line)
                        .append(") ")
                        .append(entry.getKey())
                        .append(":  ")
                        .append(entry.getValue())
                        .append('\n');
                writer.write(sb.toString());
                writer.flush();
                line++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи графа");
        }
    }
}
