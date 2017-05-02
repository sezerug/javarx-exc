package tr.com.ugs.exc.service;

import rx.Observable;
import tr.com.ugs.exc.domain.Stats;

/**
 * Created by sezerug on 01/05/2017.
 */
public interface IReportService {

    Observable<Stats> sortByAirportCountAsc();

    Observable<Stats> filterByLowestAirportCount();

    Observable<Stats> filterByHighestAirportCount();

    Observable<Stats> filterTopRunwayIdentifications();

}
