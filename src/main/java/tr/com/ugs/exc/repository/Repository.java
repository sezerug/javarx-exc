package tr.com.ugs.exc.repository;

import rx.Observable;

/**
 * Created by usezer on 27.04.2017.
 */
public interface Repository<T> {
    Observable<T> getData();
}
