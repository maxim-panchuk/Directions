package io;

import com.opencsv.bean.CsvToBeanBuilder;
import model.Distance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvDistanceReader {

    public void readCsv(DistancesGraphBuilder distancesGraphBuilder) {
        String fileName = "/Users/maksimpancuk/Desktop/SearchDirections/src/main/resources/distances.csv";
        try {
            List<Distance> distanceList = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(Distance.class)
                    .withSeparator(';')
                    .build()
                    .parse();
            distanceList.forEach(x -> distancesGraphBuilder.getMap().put(x.getCity(), x.getDistance()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
