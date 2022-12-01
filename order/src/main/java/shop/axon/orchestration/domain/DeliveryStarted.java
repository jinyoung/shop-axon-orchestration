package shop.axon.orchestration.domain;

import java.util.*;
import lombok.Data;
import shop.axon.orchestration.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private String address;
    private String customerId;
    private Integer quantity;
    private Long orderId;
}
