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
public class DeliveryAggregate {

    @AggregateIdentifier
    private Long id;
    private String address;
    private String customerId;
    private Integer quantity;
    private Long orderId;

    public DeliveryAggregate(){}

    @CommandHandler
    public void handle(ReturnDeliveryCommand command){

        DeliveryReturnedEvent event = new DeliveryReturnedEvent();
        BeanUtils.copyProperties(command, event);     


        apply(event);

    }

    @CommandHandler
    public DeliveryAggregate(AddToDeliveryListCommand command){

        DeliveryStartedEvent event = new DeliveryStartedEvent();
        BeanUtils.copyProperties(command, event);     

                //Please uncomment here and implement the createUUID method.
        //event.setId(createUUID());
        
        apply(event);

    }








    @EventSourcingHandler
    public void on(DeliveryStartedEvent event) {
        BeanUtils.copyProperties(event, this);
        
    }


    @EventSourcingHandler
    public void on(DeliveryReturnedEvent event) {
        BeanUtils.copyProperties(event, this);
        
    }


}

