package simplepool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by mkhanwalkar on 12/19/15.
 */
public class PoolFactory {

    ConcurrentMap<String,Pool> pools = new ConcurrentHashMap<>();

    public void registerPool(Pool pool)
    {
        pools.put(pool.getName(),pool);
    }

    public Pool getPool(String name)
    {
        return pools.get(name) ;
    }


    public static PoolFactory getInstance()
    {
        return Holder.factory;
    }

    static class Holder
    {
        static PoolFactory factory = new PoolFactory();
    }

}
