package tr.com.ugs.exc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.Observable;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.domain.Country;
import tr.com.ugs.exc.service.IQueryService;

/**
 * Created by sezerug on 01/05/2017.
 */
@Component("queryService")
public class QueryService implements IQueryService {

    private CountryService countryService = new CountryService();
    private AirportService airportService = new AirportService();

    @Override
    public Observable<Airport> filterByCountry(String countryCode) {
        Observable<Country> countrySource = countryService.filterByCode(countryCode);
        Observable<Airport> airportSource = countrySource.flatMap(country ->
                airportService.filterByIsoCountry(country.getCode()));
        return airportSource;
    }

}
