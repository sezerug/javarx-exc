package tr.com.ugs.exc.service;

import rx.Observable;
import tr.com.ugs.exc.domain.Country;


/**
 * Created by usezer on 27.04.2017.
 */
public interface ICountryService {
    Observable<Country> filterByCountryCode(String countryCode);
}
