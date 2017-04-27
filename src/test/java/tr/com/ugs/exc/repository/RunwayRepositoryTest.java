package tr.com.ugs.exc.repository;

import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Runway;

import static org.junit.Assert.assertEquals;

/**
 * Created by usezer on 27.04.2017.
 */
public class RunwayRepositoryTest {

    private RunwayRepository repository;

    @Before
    public void setUp() {
        repository = new RunwayRepository();
    }

    @Test
    public void getRunwayByIdSuccess() {
        int id = 239260;
        int airportRef = 4528;
        repository.getData().filter(runway -> airportRef == runway.getAirportRef()).subscribe(System.out::println);
        Runway expected = new Runway(239260, 4528, "LTBA", 8530, 197, "ASP", 1, 0, "05");
        Runway actual = repository.getData().filter(runway -> id == runway.getId()).toBlocking().single();
        assertEquals(expected, actual);
    }
}
