package personal.haidchen.simplecs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.IntegerSerializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
public class KafkaConfig {

    @Value("${simplec.kafka.topic.name}")
    private String kafkaTopicName;

    @Value("${simplec.kafka.bootstrap.servers}")
    private String kafkaBrokers;

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(kafkaTopicName)
                           .partitions(1)
                           .replicas(1)
                           .build();
    }

    @Bean
    public ProducerFactory<Integer, byte[]> producerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokers);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<Integer, byte[]> kafkaTemplate() {
        KafkaTemplate<Integer, byte[]> template = new KafkaTemplate<>(producerFactory());
        template.setDefaultTopic(kafkaTopicName);

        return template;
    }
}
