package simplepool;

/**
 * Wrapper around a pooled object to enable housekeeping
 */
public class PoolData<T> {

    T t ;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //TODO - time to be used for determining idle
}
