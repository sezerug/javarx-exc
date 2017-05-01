package tr.com.ugs.exc.service;

import rx.Observable;
import tr.com.ugs.exc.domain.Runway;

/**
 * Created by sezerug on 27/04/2017.
 */
public interface IRunwayService {

    Observable<Runway> filterByAirportRef(int airportRef);

}
