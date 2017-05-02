package tr.com.ugs.exc.service;

import rx.Observable;
import tr.com.ugs.exc.domain.Airport;

/**
 * Created by sezerug on 27/04/2017.
 */
public interface IAirportService {

    Observable<Airport> listAll();

    Observable<Airport> filterByIsoCountry(String isoCountry);

}
