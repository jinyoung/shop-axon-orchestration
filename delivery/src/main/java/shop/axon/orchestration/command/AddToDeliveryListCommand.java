package shop.axon.orchestration.command;

import lombok.Data;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@ToString
@Data
public class AddToDeliveryListCommand {

    @TargetAggregateIdentifier
    private Long id;

    private String address;
    private String customerId;
    private Integer quantity;
    private Long orderId;
}
