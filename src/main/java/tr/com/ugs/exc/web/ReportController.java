package tr.com.ugs.exc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.rx.RxResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import rx.schedulers.Schedulers;
import tr.com.ugs.exc.service.impl.ReportService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

/**
 * Created by sezerug on 01/05/2017.
 */
@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(method = RequestMethod.GET, value = "/airports/desc")
    public SseEmitter filterByHighestAirportCount() {
        return RxResponse.sse(APPLICATION_JSON_UTF8, reportService.filterByHighestAirportCount()
                .subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/airports/asc")
    public SseEmitter filterByLowestAirportCount() {
        return RxResponse.sse(APPLICATION_JSON_UTF8, reportService.filterByLowestAirportCount()
                .subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/runways")
    public SseEmitter filterTopRunwayIdentifications() {
        return RxResponse.sse(APPLICATION_JSON_UTF8, reportService.filterTopRunwayIdentifications()
                .subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()));
    }
}
