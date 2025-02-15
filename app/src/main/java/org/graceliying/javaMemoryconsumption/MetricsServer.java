package org.graceliying.javaMemoryconsumption;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;

import java.io.IOException;
public class MetricsServer {
    public static void main(String[] args) throws IOException {
        // Register default JVM metrics
        DefaultExports.initialize();

        // Start an HTTP server on port 5556 to expose Prometheus metrics
        HTTPServer server = new HTTPServer(5556);

        System.out.println("Prometheus metrics available at http://localhost:5556/metrics");

        KafkaStreamsDemo.startKafkaStream();
    }
}
