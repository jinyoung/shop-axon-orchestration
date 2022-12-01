package shop.axon.orchestration.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class OrderCommand {


        private Long id;  // Please comment here if you want user to enter the id directly
        private String productId;
    private Integer qty;
    private String customerId;
    private BigDecimal amount;
    private String status;
    private String address;

}
