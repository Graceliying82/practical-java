package org.graceliying.javaMemoryconsumption;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class JsonSerde implements Serde<JsonNode> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JsonSerializer serializer = new JsonSerializer();
    private final JsonDeserializer deserializer = new JsonDeserializer();

    @Override
    public Serializer<JsonNode> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<JsonNode> deserializer() {
        return deserializer;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public void close() {}

    public static class JsonSerializer implements Serializer<JsonNode> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public byte[] serialize(String topic, JsonNode data) {
            try {
                return objectMapper.writeValueAsBytes(data);
            } catch (Exception e) {
                throw new RuntimeException("Error serializing JSON", e);
            }
        }
    }

    public static class JsonDeserializer implements Deserializer<JsonNode> {
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public JsonNode deserialize(String topic, byte[] data) {
            try {
                return objectMapper.readTree(data);
            } catch (Exception e) {
                return null; // Handle error gracefully
            }
        }
    }
}
