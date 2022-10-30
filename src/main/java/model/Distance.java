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
public class Distance {

    @CsvBindByPosition(position = 0)
    private String city;

    @CsvBindByPosition(position = 1)
    private int distance;

    @Override
    public String toString() {
        return city + "  " + distance;
    }
}
