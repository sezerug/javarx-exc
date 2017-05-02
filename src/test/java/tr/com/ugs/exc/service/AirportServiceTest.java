package tr.com.ugs.exc.service;

import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.service.impl.AirportService;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by usezer on 27.04.2017.
 */
public class AirportServiceTest {

    private AirportService service;

    @Before
    public void setUp() {
        service = new AirportService();
    }

    @Test
    public void listAllSuccess() {
        int numberOfAirports = 46505;
        List<Airport> airports = service.listAll().toList().toBlocking().first();
        assertEquals(numberOfAirports, airports.size());
    }

    @Test
    public void filterByCountryCodeSuccess() {
        String isoCountry = "TR";
        int countByIsoCountry = 119;
        List<Airport> airports = service.filterByIsoCountry(isoCountry).toList().toBlocking().first();
        assertEquals(countByIsoCountry, airports.size());
    }
}
