package shop.axon.orchestration.domain;

import java.util.*;
import lombok.*;
import shop.axon.orchestration.domain.*;
import shop.axon.orchestration.infra.AbstractEvent;

@Data
@ToString
public class OrderDeliveryStarted extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private String customerId;
    private Double amount;
    private String status;
    private String address;

    public OrderDeliveryStarted(Order aggregate) {
        super(aggregate);
    }

    public OrderDeliveryStarted() {
        super();
    }
}
