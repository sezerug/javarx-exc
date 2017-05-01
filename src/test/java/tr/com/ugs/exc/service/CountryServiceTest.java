package tr.com.ugs.exc.service;

import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Country;
import tr.com.ugs.exc.service.impl.CountryService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by usezer on 27.04.2017.
 */
public class CountryServiceTest {
    private CountryService service;

    @Before
    public void setUp() {
        service = new CountryService();
    }

    @Test
    public void filterByCountryCodeSuccess() {
        Country expected = new Country(302667, "TR", "Turkey", "AS", new ArrayList<>());
        Country actual = service.filterByCode("TR").toBlocking().first();
        assertEquals(expected, actual);
    }
}
