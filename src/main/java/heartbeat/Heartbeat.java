package heartbeat;

/**
 * Created by mkhanwalkar on 12/21/15.
 */
public class Heartbeat {

    String targetHost ;
    int port ;
    int interval ;
    int numMisses;

    public Heartbeat(int port, String targetHost, int interval , int numMisses)
    {
        this.targetHost = targetHost;
        this.port = port ;
        this.interval = interval ;
        this.numMisses = numMisses;
    }


    // try to connect to target host , if successful set up task to connect to host .
    // else set up server to listen to incoming connections .

    public void init()
    {

    }


    public void destroy()
    {

    }
}
