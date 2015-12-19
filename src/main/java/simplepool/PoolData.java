package simplepool;

/**
 * Wrapper around a pooled object to enable housekeeping
 */
public class PoolData<T> {

    T t ;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    //TODO - time to be used for determining idle
}
