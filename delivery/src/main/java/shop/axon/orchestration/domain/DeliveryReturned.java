package shop.axon.orchestration.domain;

import java.util.*;
import lombok.*;
import shop.axon.orchestration.domain.*;
import shop.axon.orchestration.infra.AbstractEvent;

@Data
@ToString
public class DeliveryReturned extends AbstractEvent {

    private Long id;

    public DeliveryReturned(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryReturned() {
        super();
    }
}
