package tr.com.ugs.exc.service;

import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.domain.Country;
import tr.com.ugs.exc.service.impl.QueryService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by usezer on 27.04.2017.
 */
public class QueryServiceTest {
    private QueryService service;

    @Before
    public void setUp() {
        service = new QueryService();
    }

    @Test
    public void filterByCountryCodeSuccess() {
        String isoCountry = "TR";
        int numberOfAirports = 119;
        Country country = service.filterByCountryCode(isoCountry).toList().toBlocking().first().get(0);
        assertNotNull(country);
        assertEquals(numberOfAirports, country.getAirports().size());
    }
}
