package tr.com.ugs.exc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by usezer on 27.04.2017.
 */
@Data
@AllArgsConstructor
public class Country {
    private int id;
    private String code;
    private String name;
    private String continent;
}
