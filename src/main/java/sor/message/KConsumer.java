package sor.message;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.*;


public class KConsumer {
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
      //  properties.put("partition.assignment.strategy", "range");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaConsumer consumer = new KafkaConsumer(properties);

        List<String> list = new ArrayList<>();
        list.add("test1");
        consumer.subscribe(list);

      //  System.out.println(consumer.subscription());

        System.out.println(consumer.metrics());

        boolean isRunning = true;
        while(isRunning) {
            ConsumerRecords records = consumer.poll(10000);
            System.out.println(records.count());
            records.iterator().forEachRemaining(r -> {System.out.println(r);});

            //Thread.sleep(1000);
        }
        consumer.close();
    }
}