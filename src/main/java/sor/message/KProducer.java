package sor.message;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class KProducer {
    final static String TOPIC = "test1";


    public static void main(String[] argv) throws Exception {
        Properties properties = new Properties();
        properties.put("metadata.broker.list","localhost:9092");
        properties.put("serializer.class","kafka.serializer.StringEncoder");
        properties.put("bootstrap.servers", "localhost:9092");

        properties.put("zk.connect","127.0.0.1:2181");

        properties.put("group.id", "test");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
     //   properties.put("partition.assignment.strategy", "range");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
       // props.put("metadata.broker.list", "broker1:9092,broker2:9092");

       // ProducerConfig producerConfig = new ProducerConfig(properties);
        Producer<String,String> producer = new KafkaProducer<String, String>(properties);
        SimpleDateFormat sdf = new SimpleDateFormat();


        for (int i=0;i<1000;i++) {
            ProducerRecord<String, String> message = new ProducerRecord<String, String>(TOPIC, "Test message from java program " + sdf.format(System.nanoTime()));
            producer.send(message);
        }

        Thread.sleep(1000);
        producer.close();
    }
}