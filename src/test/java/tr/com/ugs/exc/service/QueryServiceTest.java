package tr.com.ugs.exc.service;

import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.service.impl.QueryService;

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
        List<Airport> airports = service.filterByCountryCode(isoCountry).toList().toBlocking().first();
        assertNotNull(airports);
        assertEquals(numberOfAirports, airports.size());
    }
}
