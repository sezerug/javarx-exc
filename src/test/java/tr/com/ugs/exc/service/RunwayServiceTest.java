package tr.com.ugs.exc.service;

import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.domain.Runway;
import tr.com.ugs.exc.service.impl.RunwayService;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by usezer on 27.04.2017.
 */
public class RunwayServiceTest {

    private RunwayService service;

    @Before
    public void setUp() {
        service = new RunwayService();
    }

    @Test
    public void filterByAirportRefSuccess() {
        int airportRef = 4528;
        int numberOfRunways = 3;
        Airport airport = new Airport(airportRef, "LTBA", "large_airport", "Atatürk International Airport", "TR");
        List<Runway> runways = service.filterByAirportRef(airport.getId()).toList().toBlocking().first();
        assertEquals(numberOfRunways, runways.size());
    }
}
