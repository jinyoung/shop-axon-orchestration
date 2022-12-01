package shop.axon.orchestration.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import shop.axon.orchestration.config.kafka.KafkaProcessor;
import shop.axon.orchestration.domain.*;

@Service
public class OrderStatusViewHandler {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderStatus orderStatus = new OrderStatus();
            // view 객체에 이벤트의 Value 를 set 함
            orderStatus.setId(orderPlaced.getId());
            orderStatus.setStatus(orderPlaced.getStatus());
            orderStatus.setAmount(Long.valueOf(orderPlaced.getAmount()));
            orderStatus.setQty(orderPlaced.getQty());
            // view 레파지 토리에 save
            orderStatusRepository.save(orderStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(
                deliveryStarted.getOrderId()
            );

            if (orderStatusOptional.isPresent()) {
                OrderStatus orderStatus = orderStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("DeliveryStarted");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelled_then_UPDATE_2(
        @Payload OrderCancelled orderCancelled
    ) {
        try {
            if (!orderCancelled.validate()) return;
            // view 객체 조회
            Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(
                orderCancelled.getId()
            );

            if (orderStatusOptional.isPresent()) {
                OrderStatus orderStatus = orderStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderStatus.setStatus("Cancelled");
                // view 레파지 토리에 save
                orderStatusRepository.save(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
