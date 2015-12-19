import simplepool.Pool;
import simplepool.PoolFactory;

/**
 * Created by mkhanwalkar on 12/19/15.
 */
public class PoolTester {

    public static void main(String[] args) throws Exception  {
        PoolFactory factory = PoolFactory.getInstance();
        Pool<DBWrapper> dbPool = new Pool<>(DBWrapper.class, "DB");
        dbPool.init(1,1,10000);
        factory.registerPool(dbPool);
        DBWrapper wrapper = (DBWrapper) factory.getPool("DB").checkout();

        wrapper.init(); //TODO - this needs to be in the pool
        wrapper.persist(100, "Hello World");
        wrapper.destroy();

        factory.getPool("DB").checkin(wrapper);


    }
}


//TODO - create a DB connection wrapper
