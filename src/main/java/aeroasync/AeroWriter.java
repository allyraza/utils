package aeroasync;

import com.aerospike.client.*;

/**
 * Created by mkhanwalkar on 4/2/16.
 */
public class AeroWriter {

    String host = "localhost";

    int port = 3000;

    AerospikeClient client ;


    public AeroWriter()
    {
        client = new AerospikeClient(host,port);
    }


    public void write(Profile profile)
    {

        com.aerospike.client.Key key = new com.aerospike.client.Key("test", "demo", profile.getId());
        Bin bin1 = new Bin("bin1", profile.toJSon());
       // Bin bin2 = new Bin("bin2", "value2");

    //    console.info("Put: namespace=%s set=%s key=%s bin1=%s value1=%s bin2=%s value2=%s",
      //          key.namespace, key.setName, key.userKey, bin1.name, bin1.value, bin2.name, bin2.value);

        client.put(null, key, bin1);


    }


}
