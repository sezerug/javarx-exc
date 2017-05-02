package tr.com.ugs.exc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sezerug on 02/05/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stats {
    private String name;
    private int count;
}
