import simplepool.Wrapper;

/**
 * Created by mkhanwalkar on 12/19/15.
 */
public class DummyWrapper implements Wrapper {

    public void process()
    {
        System.out.println("Hello World from " + this  + "  " + Thread.currentThread().getName()) ;
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }
}
