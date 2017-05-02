package tr.com.ugs.exc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.rx.RxResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import rx.schedulers.Schedulers;
import tr.com.ugs.exc.service.impl.QueryService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

/**
 * Created by sezerug on 01/05/2017.
 */
@RestController
@RequestMapping("/queries")
public class QueryController {
    private static final Logger LOG = LoggerFactory.getLogger(QueryController.class);

    @Autowired
    private QueryService queryService;

    @RequestMapping(method = RequestMethod.GET, value = "/{code}")
    public SseEmitter country(@PathVariable("code") String code) {
        LOG.info("Listing countries...");
        return RxResponse.sse(APPLICATION_JSON_UTF8, queryService.filterByCountryCode(code).subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()));
    }
}