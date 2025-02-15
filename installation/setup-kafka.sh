#!/bin/bash

set -e  # Exit immediately if a command exits with a non-zero status.

echo "Starting Kafka and Zookeeper using Docker Compose..."
docker compose up -d

# Wait for Kafka to be ready
echo "Waiting for Kafka to be fully initialized..."
sleep 10

# Create the topic
echo "Creating Kafka topic: cpu-mem-demo..."
docker exec -it kafka kafka-topics --create --topic cpu-mem-demo --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1 || echo "Topic already exists."
echo "Creating Kafka topic: processed-demo..."
docker exec -it kafka kafka-topics --create --topic processed-demo --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1 || echo "Topic already exists."
# Verify topic creation
echo "Listing available Kafka topics..."
docker exec -it kafka kafka-topics --list --bootstrap-server localhost:9092

echo "Kafka setup is complete!"
