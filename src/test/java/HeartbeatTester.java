import heartbeat.Heartbeat;

/**
 * Created by mkhanwalkar on 12/21/15.
 */
public class HeartbeatTester {

    public static void main(String[] args) throws Exception {

        if (args[0].equals("server")) {

            HBTServer server = new HBTServer();

            server.start();

        }
        else {

            HBTClient client = new HBTClient();
            client.start();

        }

    }



}




