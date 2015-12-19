package simplepool;

/**
 * Created by mkhanwalkar on 12/19/15.
 */
public class Pool<T> {

    String name ;

    Class<T> typeArgumentClass;

    public Pool(Class<T> typeArgumentClass)
    {
        this.typeArgumentClass = typeArgumentClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T checkout()
    {
        return null ;
    }

    public void checkin(T t )
    {

    }

    int min , max , timeIdle;

    public void init(int min , int max , int timeIdle) throws IllegalAccessException, InstantiationException {
        this.min = min;
        this.max = max;
        this.timeIdle= timeIdle;


        for (int i=0;i<min;i++)
        {

            PoolData<T> data = new PoolData<T>();
            data.setT(typeArgumentClass.newInstance());
        }
    }


}
