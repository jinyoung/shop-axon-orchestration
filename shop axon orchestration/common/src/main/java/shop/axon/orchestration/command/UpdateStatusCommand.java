package shop.axon.orchestration.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UpdateStatusCommand {


    @TargetAggregateIdentifier
    private Long id;


}
