import heartbeat.Heartbeat;

public class HBTServer
{
    public void start()
    {
        Heartbeat beat = new Heartbeat(21000, "localhost", 10, 10);
        beat.init();

    }
}