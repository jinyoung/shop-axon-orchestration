package shop.axon.orchestration.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.*;
import org.axonframework.spring.stereotype.Aggregate;

import org.springframework.beans.BeanUtils;
import java.util.List;

import lombok.Data;
import lombok.ToString;




import shop.axon.orchestration.command.*;
import shop.axon.orchestration.event.*;

@Aggregate
@Data
@ToString
public class InventoryAggregate {

    @AggregateIdentifier
    private Long id;
    private Long orderId;
    private Integer qty;

    public InventoryAggregate(){}

    @CommandHandler
    public InventoryAggregate(DecreaseInventoryCommand command){

    }

    @CommandHandler
    public InventoryAggregate(IncreaseInventoryCommand command){

    }








    @EventSourcingHandler
    public void on(InventoryDescreasedEvent event) {
        BeanUtils.copyProperties(event, this);
        
    }


    @EventSourcingHandler
    public void on(InventoryIncreasedEvent event) {
        BeanUtils.copyProperties(event, this);
        
    }


}

