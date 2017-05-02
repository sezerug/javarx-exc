package tr.com.ugs.exc.repository;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tr.com.ugs.exc.domain.Country;
import tr.com.ugs.exc.util.CSVUtils;

import java.util.ArrayList;

/**
 * Created by usezer on 27.04.2017.
 */
public class CountryRepository implements Repository<Country> {
    private static final String FILE_NAME = "countries.csv";

    @Override
    public Observable<Country> getData() {
        return Observable.from(CSVUtils.getReader(FILE_NAME)).skip(1).map(mapToCountry).subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread());
    }

    private Func1<String[], Country> mapToCountry = (line) -> (
            new Country(Integer.parseInt(line[0]), line[1], line[2], line[3], new ArrayList<>())
    );
}
