package tr.com.ugs.exc.service.impl;

import rx.Observable;
import tr.com.ugs.exc.domain.Country;
import tr.com.ugs.exc.repository.CountryRepository;
import tr.com.ugs.exc.service.ICountryService;

/**
 * Created by usezer on 27.04.2017.
 */
public class CountryService implements ICountryService {

    private final CountryRepository repository = new CountryRepository();

    @Override
    public Observable<Country> filterByCountryCode(String countryCode) {
        return repository.getData().filter(country -> country.getCode().equals(countryCode));
    }
}
