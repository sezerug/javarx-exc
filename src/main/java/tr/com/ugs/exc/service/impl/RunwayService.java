package tr.com.ugs.exc.service.impl;

import org.springframework.stereotype.Component;
import rx.Observable;
import tr.com.ugs.exc.domain.Runway;
import tr.com.ugs.exc.repository.RunwayRepository;
import tr.com.ugs.exc.service.IRunwayService;

/**
 * Created by sezerug on 01/05/2017.
 */
@Component("runwayService")
public class RunwayService implements IRunwayService {

    private final RunwayRepository repository = new RunwayRepository();

    @Override
    public Observable<Runway> filterByAirportRef(int airportRef) {
        return repository.getData().filter(runway -> runway.getAirportRef() == airportRef);
    }
}
