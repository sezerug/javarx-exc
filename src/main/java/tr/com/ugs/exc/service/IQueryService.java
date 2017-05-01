package tr.com.ugs.exc.service;

import rx.Observable;
import tr.com.ugs.exc.domain.Country;

/**
 * Created by sezerug on 01/05/2017.
 */
public interface IQueryService {

    Observable<Country> filterByCountryCode(String code);

}
