kafkaCreateTopics="docker exec profile-kafka /kafka/bin/kafka-topics.sh --create --topic {topic} --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1"

${kafkaCreateTopics/"{topic}"/profile}

