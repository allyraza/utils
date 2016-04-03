package aeroasync;

import com.aerospike.client.*;
import com.aerospike.client.Key;
import com.aerospike.client.async.AsyncClient;
import com.aerospike.client.async.AsyncClientPolicy;
import com.aerospike.client.listener.RecordListener;
import com.aerospike.client.listener.WriteListener;

/**
 * Created by mkhanwalkar on 4/2/16.
 */
public class AeroWriter {

    String host = "localhost";

    int port = 3000;

    AerospikeClient client ;

    AsyncClientPolicy policy = new AsyncClientPolicy();

    AsyncClient aclient ;



    public AeroWriter()
    {
        client = new AerospikeClient(host,port);
        aclient = new AsyncClient(policy, host, port);


        policy.asyncMaxCommands = 300;
        policy.asyncSelectorThreads = 1;
        policy.asyncSelectorTimeout = 10;
        policy.failIfNotConnected = true;
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


    public void awrite(Profile profile)
    {

        com.aerospike.client.Key key = new com.aerospike.client.Key("test", "demo", profile.getId());
        Bin bin1 = new Bin("bin1", profile.toJSon());

        aclient.put(null, new WriteListener() {
            @Override
            public void onSuccess(Key key) {

            }

            @Override
            public void onFailure(AerospikeException e) {

            }
        },key, bin1);



    }


}
