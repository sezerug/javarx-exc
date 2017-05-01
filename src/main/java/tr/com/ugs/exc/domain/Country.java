package tr.com.ugs.exc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usezer on 27.04.2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private int id;
    private String code;
    private String name;
    private String continent;
    private List<Airport> airports = new ArrayList<>();
}
