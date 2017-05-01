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

    @Test
    public void groupByIsoCountry() {
        repository.getData().filter(airport -> airport.getIsoCountry().startsWith("T")).groupBy(Airport::getIsoCountry)
                .flatMap(groups -> groups.collect(Bucket::new, (bucket, rows) -> {
                    bucket.name = rows.getIsoCountry();
                    bucket.airports.add(rows);
                })).sorted((bucket1, bucket2) -> Integer.compare(bucket1.airports.size(), bucket2.airports.size()))
                .subscribe(System.out::println);
    }

    public static class Bucket {
        public String name;
        public List<Airport> airports = new ArrayList<>();

        @Override
        public String toString() {
            String str = " (" + name + ") [ ";
            for (Airport airport : airports) {
                str += (airport.toString() + " ");
            }
            str += "]";
            return str;
        }
    }
}
