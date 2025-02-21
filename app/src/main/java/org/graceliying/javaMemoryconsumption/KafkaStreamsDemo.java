package org.graceliying.javaMemoryconsumption;

import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Properties;

public class KafkaStreamsDemo {
    private static final String INPUT_TOPIC = "cpu-mem-demo";
    private static final String OUTPUT_TOPIC = "processed-demo";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void startKafkaStream() {
        startStreamProcessing();
    }

    public static void startStreamProcessing() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "order-stream-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/kafka-streams"); // RocksDB storage

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> stream = builder.stream(INPUT_TOPIC);

        // Parse and process JSON orders
        KTable<String, Long> orderCountsByState = stream
            .mapValues(value -> parseJson(value)) // Convert JSON string to JSON object
            .filter((key, value) -> value != null && value.has("state")) // Ensure it has a state field
            .groupBy((key, value) -> value.get("state").asText(), Grouped.with(Serdes.String(), new JsonSerde())) // Use correct JSON serde
            .count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>> as("order-count-store")
                .withKeySerde(Serdes.String())
                .withValueSerde(Serdes.Long()));

        // Convert count to output messages
        orderCountsByState.toStream()
            .mapValues(count -> "Orders in state: " + count)
            .to(OUTPUT_TOPIC, Produced.with(Serdes.String(), Serdes.String()));

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

    private static JsonNode parseJson(String value) {
        try {
            return objectMapper.readTree(value);
        } catch (Exception e) {
            return null; // Ignore non-JSON messages
        }
    }
}
