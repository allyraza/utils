import heartbeat.Heartbeat;

/**
 * Created by mkhanwalkar on 12/21/15.
 */
public class HeartbeatTester {

    public static void main(String[] args) throws Exception {

        HBTServer server = new HBTServer();

        server.start();

        Thread.sleep(1000);

        HBTClient client = new HBTClient();
        client.start();

    }



}


class HBTClient
{
    public void start()
    {
        Heartbeat beat = new Heartbeat(21000, "localhost", 10, 10);
        beat.init();

    }
}


class HBTServer
{
    public void start()
    {
        Heartbeat beat = new Heartbeat(21000, "localhost", 10, 10);
        beat.init();

    }
}