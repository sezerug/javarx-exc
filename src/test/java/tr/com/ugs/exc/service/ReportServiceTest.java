package tr.com.ugs.exc.service;

import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Stats;
import tr.com.ugs.exc.service.impl.ReportService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by usezer on 27.04.2017.
 */
public class ReportServiceTest {
    private ReportService service;

    @Before
    public void setUp() {
        service = new ReportService();
    }

    @Test
    public void sortByAirportCountSuccess() {
        int highestNumberOfAirports = 21501;
        //Get the country with the highest number of Airport
        Stats stats = service.sortByAirportCountAsc().toBlocking().last();
        assertNotNull(stats);
        assertEquals(highestNumberOfAirports, stats.getCount());
    }

    @Test
    public void filterByLowestAirportCountSuccess() {
        Stats andorraStats = new Stats("Andorra", 1);
        List<Stats> statsList = service.filterByLowestAirportCount().toList().toBlocking().last();
        assertNotNull(statsList);
        assertEquals(10, statsList.size());
        assertEquals(Boolean.TRUE, statsList.contains(andorraStats));
    }

    @Test
    public void filterByHighestAirportCountSuccess() {
        Stats usStats = new Stats("United States", 21501);
        List<Stats> statsList = service.filterByHighestAirportCount().toList().toBlocking().last();
        assertNotNull(statsList);
        assertEquals(10, statsList.size());
        assertEquals(Boolean.TRUE, statsList.contains(usStats));
    }

    @Test
    public void filterTopRunwayIdentificationsSuccess() {
        Stats stats = new Stats("H1", 5566);
        List<Stats> statsList = service.filterTopRunwayIdentifications().toList().toBlocking().last();
        assertNotNull(statsList);
        assertEquals(10, statsList.size());
        assertEquals(Boolean.TRUE, statsList.contains(stats));
    }
}
