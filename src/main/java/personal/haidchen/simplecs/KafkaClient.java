package personal.haidchen.simplecs;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;


@Component
public class KafkaClient {

    private final KafkaTemplate<Integer, byte[]> template;

    public KafkaClient(KafkaTemplate<Integer, byte[]> template) {
        this.template = template;
    }

    public void send(List<String> value) {
        byte[] valueToSend = toByteArr(value);
        CompletableFuture<SendResult<Integer, byte[]>> future = template.sendDefault(valueToSend);

        future.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Successfully sent to Kafka. Result : " + result);
            } else {
                exception.printStackTrace();
            }
        });
    }

    private byte[] toByteArr(List<String> value) {
        try (ByteArrayOutputStream byteArrOut = new ByteArrayOutputStream();
                ObjectOutputStream objOut = new ObjectOutputStream(byteArrOut)) {
            objOut.writeObject(value);

            return byteArrOut.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
