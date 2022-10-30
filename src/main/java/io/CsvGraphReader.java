package io;

import com.opencsv.bean.CsvToBeanBuilder;
import model.Adjacency;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvGraphReader {

    public void readCsv(GraphBuilder graphBuilder) {
        String fileName = "/Users/maksimpancuk/Desktop/SearchDirections/src/main/resources/adjacency.csv";
        try {
            List<Adjacency> refs = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(Adjacency.class)
                    .withSeparator(' ')
                    .withSkipLines(1)
                    .build()
                    .parse();
            refs.forEach(x -> graphBuilder.getRefs().add(x));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
