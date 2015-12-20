package simplepool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mkhanwalkar on 12/19/15.
 */
public class Pool<T> {

    String name ;

    Class<T> typeArgumentClass;

    BlockingQueue<PoolData<T>> poolDatas = new LinkedBlockingQueue<>();

    public Pool(Class<T> typeArgumentClass, String name)
    {
        this.typeArgumentClass = typeArgumentClass;
        this.name = name ; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized T checkout()
    {
        try {
            if (poolDatas.isEmpty())
             check();
            PoolData<T> pData = poolDatas.take();
            T t = pData.get();
            return t ;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void checkin(T t )
    {
        PoolData<T> data = new PoolData<T>();
        data.set(t);
        poolDatas.add(data);

    }

    private  void check()
    {

        if (currenCount.get() < max)
        {
            currenCount.incrementAndGet();
        }
        add();

    }

    private void add()  {
        try {
            PoolData<T> data = new PoolData<T>();
            data.set(typeArgumentClass.newInstance());
            poolDatas.add(data);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    int min , max ;

    int timeIdle;

    AtomicInteger currenCount = new AtomicInteger(0);

    public void init(int min , int max , int timeIdle)  {
        this.min = min;
        this.max = max;
        this.timeIdle= timeIdle;


        for (int i=0;i<min;i++)
        {

           add();

        }

        currenCount.set(min);
    }

    public void printSize()
    {
        System.out.println(currenCount.get());
    }

    public void destroy()
    {
        //TODO - change from T to a better interface and then call destroy on each instance

    }


    public synchronized  void clean() {
        long currTime = System.currentTimeMillis();
        while(true) {
            PoolData<T> data = poolDatas.peek();
            if (data==null)
                break;
            if (currTime - timeIdle > data.getLastTime()) {
                poolDatas.remove();
                currenCount.decrementAndGet();
            }
            else
                break ;

        }
    }
}
