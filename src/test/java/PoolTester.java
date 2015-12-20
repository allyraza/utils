import simplepool.Pool;
import simplepool.PoolFactory;

/**
 * Created by mkhanwalkar on 12/19/15.
 */
public class PoolTester {

    public static void main(String[] args) throws Exception  {

  /*      {
            PoolFactory factory = PoolFactory.getInstance();

            Pool<DBWrapper> dbPool = new Pool<>(DBWrapper.class, "DB");
            dbPool.init(1, 1, 10000);
            factory.registerPool(dbPool);
            DBWrapper wrapper = (DBWrapper) factory.getPool("DB").checkout();

            wrapper.init(); //TODO - this needs to be in the pool
            wrapper.persist(100, "Hello World");
            wrapper.destroy();

            factory.getPool("DB").checkin(wrapper);

        }*/

        PoolFactory factory = PoolFactory.getInstance();


        Pool<DummyWrapper> dbPool = new Pool<>(DummyWrapper.class, "DW");
        dbPool.init(1, 10, 10000);
        factory.registerPool(dbPool);

        for (int i=0;i<5;i++) {
            Thread t = new Thread(() ->

            {

                for (int j = 0; j < 10; j++) {
                    DummyWrapper wrapper = (DummyWrapper) factory.getPool("DW").checkout();

                    wrapper.process();

                    factory.getPool("DW").checkin(wrapper);
                }
            }

            );

            t.start();
        }

        Thread.sleep(10000);

        dbPool.printSize();



    }
}


//TODO - create a DB connection wrapper
