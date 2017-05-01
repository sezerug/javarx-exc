package tr.com.ugs.exc.service;

import org.junit.Before;
import org.junit.Test;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.domain.Country;
import tr.com.ugs.exc.service.impl.QueryService;

import static org.junit.Assert.assertEquals;

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
    public void filterByCountrySuccess() {

        service.filterByCountry("TR").subscribe(airport -> System.out.println(airport));
        Country expected = new Country(302667, "TR", "Turkey", "AS");
        Airport actual = service.filterByCountry("TR").toBlocking().first();
        assertEquals(expected, actual);
    }
}
