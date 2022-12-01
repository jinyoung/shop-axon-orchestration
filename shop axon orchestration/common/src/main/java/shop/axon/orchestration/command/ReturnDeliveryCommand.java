package shop.axon.orchestration.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;



import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ReturnDeliveryCommand {


    @TargetAggregateIdentifier
    private Long id;


}
