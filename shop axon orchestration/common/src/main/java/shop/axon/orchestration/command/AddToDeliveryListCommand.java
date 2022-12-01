package shop.axon.orchestration.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;



import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class AddToDeliveryListCommand {


        private Long id;  // Please comment here if you want user to enter the id directly
        private String address;
    private String customerId;
    private Integer quantity;
    private Long orderId;

}
