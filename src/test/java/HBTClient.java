import heartbeat.Heartbeat;

class HBTClient
{
    public void start()
    {
        Heartbeat beat = new Heartbeat(21000, "localhost", 10, 10);
        beat.init();

    }
}