package org.graceliying.javaMemoryconsumption;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KafkaProducerDemo {
    private static final String TOPIC = "cpu-mem-demo";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Random random = new Random();
    private static final String[] STATES = {"CA", "NY", "TX", "FL", "WA"};

    public static void main(String[] args) {
        produceMessages();
    }

    public static void startKafka() {
        produceMessages();
    }

    private static void produceMessages() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        try {
            for (int i = 0; i < 1000; i++) {
                String key = "key-" + i;
                String message;

                if (i % 5 == 0) {  // Every 5th message is an order
                    Order order = new Order(
                        "order-" + i,
                        "user-" + random.nextInt(100),
                        "123 Main St, City",
                        STATES[random.nextInt(STATES.length)],
                        System.currentTimeMillis()
                    );
                    message = objectMapper.writeValueAsString(order);
                } else {
                    message = "Log message " + i;
                }

                producer.send(new ProducerRecord<>(TOPIC, key, message));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
            System.out.println("Kafka messages sent.");
        }
    }

    static class Order {
        public String orderId;
        public String userId;
        public String address;
        public String state;
        public long createdAt;

        public Order(String orderId, String userId, String address, String state, long createdAt) {
            this.orderId = orderId;
            this.userId = userId;
            this.address = address;
            this.state = state;
            this.createdAt = createdAt;
        }
    }
}
