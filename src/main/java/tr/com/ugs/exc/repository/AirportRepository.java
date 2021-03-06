package tr.com.ugs.exc.repository;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.util.CSVUtils;

import java.util.ArrayList;

/**
 * Created by usezer on 27.04.2017.
 */
public class AirportRepository implements Repository<Airport> {
    private static final String FILE_NAME = "airports.csv";

    @Override
    public Observable<Airport> getData() {
        return Observable.from(CSVUtils.getReader(FILE_NAME)).skip(1).map(mapToAirport).subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread());
    }

    private Func1<String[], Airport> mapToAirport = (line) -> (
            new Airport(Integer.parseInt(line[0]), line[1], line[2], line[3], line[8], new ArrayList<>())
    );
}
