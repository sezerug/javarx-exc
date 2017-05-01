package tr.com.ugs.exc.service;

import rx.Observable;
import tr.com.ugs.exc.domain.Airport;

/**
 * Created by sezerug on 01/05/2017.
 */
public interface IQueryService {

    Observable<Airport> filterByCountry(String countryCode);

}
