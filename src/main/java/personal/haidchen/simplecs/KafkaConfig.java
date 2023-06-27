package personal.haidchen.simplecs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.IntegerSerializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
public class KafkaConfig {

    private static final String TOPIC_NAME_BLABLA = "blablasFromSimplecWeb";

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(TOPIC_NAME_BLABLA)
                           .partitions(1)
                           .replicas(1)
                           .build();
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

        return props;
    }

    @Bean
    public ProducerFactory<Integer, byte[]> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<Integer, byte[]> kafkaTemplate() {
        KafkaTemplate<Integer, byte[]> template = new KafkaTemplate<>(producerFactory());
        template.setDefaultTopic(TOPIC_NAME_BLABLA);

        return template;
    }
}
