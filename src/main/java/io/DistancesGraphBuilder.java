package io;

import java.util.HashMap;

public class DistancesGraphBuilder {

    private final HashMap<String, Integer> map;

    public DistancesGraphBuilder() {
        this.map = new HashMap<>();
        CsvDistanceReader csvDistanceReader = new CsvDistanceReader();
        csvDistanceReader.readCsv(this);
    }

    public HashMap<String, Integer> getMap() {
        return this.map;
    }
}
