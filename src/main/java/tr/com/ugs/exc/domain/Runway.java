package tr.com.ugs.exc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by usezer on 27.04.2017.
 */
@Data
@AllArgsConstructor
public class Runway {
    private int id;
    private int airportRef;
    private String airportIdent;
    private int lengthFt;
    private int widthFt;
    private String surface;
    private int lighted;
    private int closed;
    private String leIdent;
}
