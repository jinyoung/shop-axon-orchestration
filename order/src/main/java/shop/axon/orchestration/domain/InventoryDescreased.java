package shop.axon.orchestration.domain;

import java.util.*;
import lombok.*;
import shop.axon.orchestration.domain.*;
import shop.axon.orchestration.infra.AbstractEvent;

@Data
@ToString
public class InventoryDescreased extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Integer qty;
}
