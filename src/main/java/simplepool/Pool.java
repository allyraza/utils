package simplepool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

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

    public T checkout()
    {
        try {
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

    int min , max , timeIdle;

    public void init(int min , int max , int timeIdle) throws IllegalAccessException, InstantiationException {
        this.min = min;
        this.max = max;
        this.timeIdle= timeIdle;


        for (int i=0;i<min;i++)
        {

            PoolData<T> data = new PoolData<T>();
            data.set(typeArgumentClass.newInstance());
            poolDatas.add(data);

        }
    }


}
