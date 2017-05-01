package tr.com.ugs.exc.service.impl;

import org.springframework.stereotype.Component;
import rx.Observable;
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
    public Observable<Country> filterByCountryCode(String code) {
        Observable<Country> countrySource = countryService.filterByCode(code);
        return countrySource.flatMap(
                country -> airportService.filterByIsoCountry(country.getCode()).toList()
                , ((country, airports) -> {
                    country.getAirports().addAll(airports);
                    return country;
                }));
    }
}
