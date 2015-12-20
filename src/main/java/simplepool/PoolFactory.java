package simplepool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by mkhanwalkar on 12/19/15.
 */
public class PoolFactory {

    ConcurrentMap<String,Pool> pools = new ConcurrentHashMap<>();
    PoolHarvestor harvestor = new PoolHarvestor(2);

    public void registerPool(Pool pool)
    {
        pools.put(pool.getName(),pool);
        harvestor.addPool(pool);

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

    public void destroy()
    {
        harvestor.destroy();
        pools.values().forEach(p->{ p.destroy(); });
    }

}
