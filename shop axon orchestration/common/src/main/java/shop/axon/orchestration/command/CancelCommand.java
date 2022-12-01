package shop.axon.orchestration.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CancelCommand {


    @TargetAggregateIdentifier
    private Long id;


}
