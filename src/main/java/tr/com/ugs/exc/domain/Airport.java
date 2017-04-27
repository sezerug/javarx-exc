package tr.com.ugs.exc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by usezer on 27.04.2017.
 */
@Data
@AllArgsConstructor
public class Airport {
    private int id; //0
    private String ident; //1
    private String type; //2
    private String name;//3
    private String isoCountry; //8
}
