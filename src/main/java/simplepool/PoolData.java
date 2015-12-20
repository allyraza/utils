package simplepool;

/**
 * Wrapper around a pooled object to enable housekeeping
 */
public class PoolData<T> {

    T t ;

    long lastTime = System.currentTimeMillis();  // set on creation

    public long getLastTime() {
        return lastTime;
    }

    public T get() {
        lastTime = System.currentTimeMillis(); // updata on get
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    //TODO - time to be used for determining idle
}
