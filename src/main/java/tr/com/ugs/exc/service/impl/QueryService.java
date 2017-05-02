package tr.com.ugs.exc.service.impl;

import org.springframework.stereotype.Component;
import rx.Observable;
import rx.schedulers.Schedulers;
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
    public Observable<Airport> filterByCountryCode(String code) {
        Observable<Country> countrySource = countryService.filterByCode(code).observeOn(Schedulers.newThread()).subscribeOn(Schedulers.newThread());
        return countrySource.flatMap(country -> airportService.filterByIsoCountry(country.getCode())
             ).subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread());
    }
}
