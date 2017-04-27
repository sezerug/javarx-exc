package tr.com.ugs.exc.repository;

import rx.Observable;
import rx.functions.Func1;
import tr.com.ugs.exc.domain.Runway;

import static tr.com.ugs.exc.util.CSVUtils.getReader;
import static tr.com.ugs.exc.util.CSVUtils.parseNotNull;

/**
 * Created by usezer on 27.04.2017.
 */
public class RunwayRepository implements Repository<Runway> {
    private static final String FILE_NAME = "runways.csv";

    @Override
    public Observable<Runway> getData() {
        return Observable.from(getReader(FILE_NAME)).skip(1).map(mapToRunway);
    }

    private Func1<String[], Runway> mapToRunway = (line) -> (
            new Runway(Integer.parseInt(line[0]), parseNotNull(line[1]).intValue(), line[2], parseNotNull(line[3]).intValue(),
                    parseNotNull(line[4]).intValue(), line[5], parseNotNull(line[6]).intValue(), parseNotNull(line[7]).intValue(), line[8]));

}
