package shop.axon.orchestration.domain;

import java.util.*;
import lombok.Data;
import shop.axon.orchestration.infra.AbstractEvent;

@Data
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private String customerId;
    private Double amount;
    private String status;
    private String address;
}
