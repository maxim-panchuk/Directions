package model;


import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adjacency {

    @CsvBindByPosition(position =  0)
    private String root;

    @CsvBindByPosition(position =  1)
    private String child;

    @CsvBindByPosition(position =  2)
    private int distance;

    @Override
    public String toString() {
        return root + " " + child + " " + distance;
    }

    public boolean connected(String a, String b) {
        return root.equals(a) && child.equals(b) || root.equals(b) && child.equals(a);
    }
}
