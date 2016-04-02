package sor.database;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mkhanwalkar on 1/16/16.
 */
public class DBWriter {

    public static void main(String[] args) {


        DBWriter writer = new DBWriter();
        writer.connect();
       // writer.test();
        //writer.test1();

     //   writer.test2();
        writer.disconnect();
        
    }

    Cluster cluster;
    Session session;


    public void connect ()
    {
         cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("dev");

    }

    public void disconnect()
    {
        session.close();
        cluster.close();

    }

    public void test1()
    {
        cluster = Cluster.builder()
                .addContactPoint("127.0.0.1")
                .build();
        Metadata metadata = cluster.getMetadata();
        System.out.printf("Connected to cluster: %s\n",
                metadata.getClusterName());
        for ( Host host : metadata.getAllHosts() ) {
            System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
                    host.getDatacenter(), host.getAddress(), host.getRack());
        }
    }

    /*public void test3()
    {
        Mapper<Account> mapper = new
                MappingManager(getSession()).mapper(Account.class);
        Phone phone = new Phone("home", "707-555-3537");
        List<Phone> phones = new ArrayList<Phone>();
        phones.add(phone);
        Address address = new Address("25800 Arnold Drive", "Sonoma", 95476,
                phones);
        Account account = new Account("John Doe", "jd@example.com", address);
        mapper.save(account);
        Account whose = mapper.get("jd@example.com");
        System.out.println("Account name: " + whose.getName());
        mapper.delete(account);
    }*/

    public void test2()
    {
        PreparedStatement insertUserPreparedStatement
                = getSession().prepare("INSERT INTO complex.users (id, name, addresses) VALUES (?, ?, ?);");
        PreparedStatement selectUserPreparedStatement
                = getSession().prepare("SELECT * FROM complex.users WHERE id = ?;");
        UserType addressUDT = getSession().getCluster()
                .getMetadata().getKeyspace("complex").getUserType("address");
        UserType phoneUDT = getSession().getCluster().getMetadata().getKeyspace("complex").getUserType("phone");
        UDTValue phone1 = phoneUDT.newValue()
                .setString("alias", "home")
                .setString("number", "1-707-555-1234");
        UDTValue phone2 = phoneUDT.newValue()
                .setString("alias", "work")
                .setString("number", "1-800-555-9876");
        UDTValue address = addressUDT.newValue()
                .setString("street", "123 Arnold Drive")
                .setInt("zip_code", 95476)
                .setList("phones", ImmutableList.of(phone1, phone2));
        Map<String, UDTValue> addresses = new HashMap<String, UDTValue>();
        addresses.put("Work", address);
       // UUID userId = UUID.fromString("fbdf82ed-0063-4796-9c7c-a3d4f47b4b25");
        getSession().execute(insertUserPreparedStatement.bind(1000, "G. Binary",
                addresses));
        Row row =
                getSession().execute(selectUserPreparedStatement.bind(1000)).one();
        for ( UDTValue addr : row.getMap("addresses", String.class,
                UDTValue.class).values() ) {
            System.out.println("Zip: " + addr.getInt("zip_code"));
        }

    }



    public void test()
    {// Connect to the cluster and keyspace "demo"

       // session.execute("INSERT INTO users1 (user_id, birth_year, name, phone_numbers) VALUES ('Jones', 1935, 'Austin', {'home': '1112223333', 'work': '2223334444'})");

        /*
          PRIMARY KEY,
     int,
     text,
     map<text, text>
         */

     //   session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");
     /*   ResultSet results = session.execute("SELECT  JSON * FROM users where lastname = 'Jones'");
        for (Row row : results) {
            System.out.println(row);
        }*/


        Cluster cluster = Cluster.builder()
                .addContactPoint("localhost")
                .build();
        Session session = cluster.connect("dev");
        Select select = QueryBuilder.select()
                .all()
                .from("dev", "users1");
        ResultSet results = session.execute(select);

        for (Row row : results) {
            System.out.println(row);
        }

        CodecRegistry myCodecRegistry =
                cluster.getConfiguration().getCodecRegistry();

        System.out.println(myCodecRegistry);

        // Note the use of named parameters in the query
        String query = "SELECT JSON * FROM dev.users where lastname=:lastname";
        Map<String, String> params = new HashMap<>();
        params.put("lastname", "Jones");
       // params.put("day", "2016-01-28");
        SimpleStatement statement = new SimpleStatement(query, params);

        ResultSet resultSet = session.execute(statement);

        for (Row row : resultSet) {
            System.out.println(row);
        }


    }

    public Session getSession() {
        return session;
    }

//TypeCodec.PrimitiveBooleanCodec


}
