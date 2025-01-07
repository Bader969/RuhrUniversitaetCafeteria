package mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MqttService {
    @Autowired
    private MessageChannel mqttOutboundChannel;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(String topic, String payload) {
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader("mqtt_topic", topic)
                .build();
        mqttOutboundChannel.send(message);
    }

    @ServiceActivator(inputChannel = "mqttInboundChannel")
    public void handleMessage(String payload) {
        // Logik zur Verarbeitung der eingehenden Nachrichten
        System.out.println("Received message: " + payload);


        try {
            Product product = objectMapper.readValue(payload, Product.class);
            // Verarbeiten des Produkts (z.B. Inventur aktualisieren)
            // inventoryService.updateInventory(product);
            System.out.println("Processed product: " + product);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
