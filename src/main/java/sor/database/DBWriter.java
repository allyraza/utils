package sor.database;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Created by mkhanwalkar on 1/16/16.
 */
public class DBWriter {

    public static void main(String[] args) {


        DBWriter writer = new DBWriter();
        writer.test();
        
    }

    Cluster cluster;
    Session session;

    public void test()
    {// Connect to the cluster and keyspace "demo"
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("dev");

       // session.execute("INSERT INTO users1 (user_id, birth_year, name, phone_numbers) VALUES ('Jones', 1935, 'Austin', {'home': '1112223333', 'work': '2223334444'})");

        /*
          PRIMARY KEY,
     int,
     text,
     map<text, text>
         */

     //   session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");
        ResultSet results = session.execute("SELECT  JSON * FROM users1");
        for (Row row : results) {
            System.out.println(row);
        }

    }

}
