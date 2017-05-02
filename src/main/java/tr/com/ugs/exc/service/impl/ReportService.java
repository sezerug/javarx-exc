package tr.com.ugs.exc.service.impl;

import org.springframework.stereotype.Component;
import rx.Observable;
import tr.com.ugs.exc.domain.Airport;
import tr.com.ugs.exc.domain.Runway;
import tr.com.ugs.exc.domain.Stats;
import tr.com.ugs.exc.service.IReportService;

/**
 * Created by sezerug on 02/05/2017.
 */
@Component("reportService")
public class ReportService implements IReportService {

    private AirportService airportService = new AirportService();
    private CountryService countryService = new CountryService();
    private RunwayService runwayService = new RunwayService();

    @Override
    public Observable<Stats> sortByAirportCountAsc() {
        return airportService.listAll().groupBy(Airport::getIsoCountry)
                .flatMap(groups -> groups.collect(Stats::new, (stats, airport) -> {
                    stats.setName(airport.getIsoCountry());
                    stats.setCount(stats.getCount() + 1);
                })).sorted((s1, s2) -> Integer.compare(s1.getCount(), s2.getCount()));
    }

    @Override
    public Observable<Stats> filterByLowestAirportCount() {
        return mapToCountry(sortByAirportCountAsc().take(10));
    }

    @Override
    public Observable<Stats> filterByHighestAirportCount() {
        return mapToCountry(sortByAirportCountAsc().takeLast(10));
    }

    @Override
    public Observable<Stats> filterTopRunwayIdentifications() {
        return runwayService.listAll().groupBy(Runway::getLeIdent)
                .flatMap(groups -> groups.collect(Stats::new, (stats, runway) -> {
                    stats.setName(runway.getLeIdent());
                    stats.setCount(stats.getCount() + 1);
                })).sorted((s1, s2) -> Integer.compare(s1.getCount(), s2.getCount())).takeLast(10);
    }

    private Observable<Stats> mapToCountry(Observable<Stats> obsStats) {
        return obsStats.flatMap(
                stats -> countryService.filterByCode(stats.getName())
                , ((stats, country) -> {
                    stats.setName(country.getName());
                    return stats;
                }));
    }
}
