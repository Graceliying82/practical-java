package org.graceliying.javaMemoryconsumption;

import java.util.Properties;
import org.apache.kafka.clients.producer.*;

public class KafkaProducerDemo {
    private static final String TOPIC = "cpu-mem-demo";

    public static void startKafka() {
        simulateCpuLoad();
        produceMessages();
    }

    private static void produceMessages() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 0; i < 1000; i++) {
            producer.send(new ProducerRecord<>(TOPIC, "key-" + i, "message-" + i));
        }

        producer.close();
        System.out.println("Kafka messages sent.");
    }

    private static void simulateCpuLoad() {
        long sum = 0;
        for (long i = 0; i < 1_000_000_000L; i++) {
            sum += i;
        }
    }
}
