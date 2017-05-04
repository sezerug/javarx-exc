package tr.com.ugs.exc.repository;


import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Airport;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by usezer on 27.04.2017.
 */
public class AirportRepositoryTest {
    private AirportRepository repository;

    @Before
    public void setUp() {
        repository = new AirportRepository();
    }

    @Test
    public void getAirportByIdSuccess() {
        int id = 4528;
        Airport expected = new Airport(id, "LTBA", "large_airport", "Atatürk International Airport", "TR", new ArrayList<>());
        Airport actual = repository.getData().filter(airport -> id == airport.getId()).toBlocking().single();
        assertEquals(expected, actual);
    }

    @Test
    public void getAirportListByIsoCountrySuccess() {
        String isoCountry = "TR";
        int countByIsoCountry = 119;
        List<Airport> airports = repository.getData().filter(airport -> airport.getIsoCountry().equals(isoCountry)).toList().toBlocking().first();
        assertEquals(countByIsoCountry, airports.size());
    }
}
