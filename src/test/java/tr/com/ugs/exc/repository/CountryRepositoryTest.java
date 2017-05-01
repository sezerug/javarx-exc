package tr.com.ugs.exc.repository;


import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Country;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by usezer on 27.04.2017.
 */
public class CountryRepositoryTest {

    private CountryRepository repository;

    @Before
    public void setUp() {
        repository = new CountryRepository();
    }

    @Test
    public void getCountryByCodeSuccess() {
        Country expected = new Country(302667, "TR", "Turkey", "AS", new ArrayList<>());
        Country actual = repository.getData().filter(country -> country.getCode().equals("TR")).toBlocking().single();
        assertEquals(expected, actual);
    }

    @Test
    public void getCountryByNameSuccess() {
        Country expected = new Country(302667, "TR", "Turkey", "AS", new ArrayList<>());
        Country actual = repository.getData().filter(country -> country.getName().equals("Turkey")).toBlocking().single();
        assertEquals(expected, actual);
    }
}
