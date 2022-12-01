package shop.axon.orchestration.event;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class DeliveryStartedEvent {

    private Long id;
    private String address;
    private String customerId;
    private Integer quantity;
    private Long orderId;
}
