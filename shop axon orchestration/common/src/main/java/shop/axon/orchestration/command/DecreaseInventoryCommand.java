package shop.axon.orchestration.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;



import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class DecreaseInventoryCommand {


        private Long id;  // Please comment here if you want user to enter the id directly
        private Long orderId;
    private Integer qty;

}
