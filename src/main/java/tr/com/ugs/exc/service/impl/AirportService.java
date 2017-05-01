package tr.com.ugs.exc.service.impl;

import org.springframework.stereotype.Component;
import rx.Observable;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.repository.AirportRepository;
import tr.com.ugs.exc.service.IAirportService;

/**
 * Created by sezerug on 01/05/2017.
 */
@Component("airportService")
public class AirportService implements IAirportService {

    private final AirportRepository repository = new AirportRepository();

    @Override
    public Observable<Airport> filterByIsoCountry(String isoCountry) {
        return repository.getData().filter(airport -> airport.getIsoCountry().equals(isoCountry));
    }
}
