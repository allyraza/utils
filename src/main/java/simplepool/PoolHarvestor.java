package simplepool;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by mkhanwalkar on 12/19/15.
 */
public class PoolHarvestor {

    int numYhreads ;

    ScheduledExecutorService scheduledPool ; //= Executors.newScheduledThreadPool(4);

    final CopyOnWriteArrayList<Pool> pools = new CopyOnWriteArrayList<>();


    public PoolHarvestor(int numThreads)
    {
        this.numYhreads = numThreads;

        scheduledPool = Executors.newScheduledThreadPool(numThreads);

        scheduledPool.scheduleWithFixedDelay(()->{
            cleanPool();
        }, 10,10 , TimeUnit.SECONDS);

    }

    public void addPool(Pool pool)
    {
        pools.add(pool);

    }

    private void cleanPool()
    {
        pools.forEach(p->{

            p.clean();

            p.printSize();


        });

    }

    public void destroy()
    {
        scheduledPool.shutdownNow();
    }




}
