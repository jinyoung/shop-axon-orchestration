package shop.axon.orchestration.policy;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.eventhandling.DisallowReplay;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.commandhandling.gateway.CommandGateway;

import shop.axon.orchestration.command.*;
import shop.axon.orchestration.event.*;
import shop.axon.orchestration.aggregate.*;


@Service
@ProcessingGroup("order")
public class PolicyHandler{

    @Autowired
    CommandGateway commandGateway;

    @EventHandler
    //@DisallowReplay
    public void wheneverOrderPlaced_Saga(OrderPlacedEvent orderPlaced){
        System.out.println(orderPlaced.toString());

        SagaCommand command = new SagaCommand();
        commandGateway.send(command);
    }
    @EventHandler
    //@DisallowReplay
    public void wheneverInventoryDescreased_Saga(InventoryDescreasedEvent inventoryDescreased){
        System.out.println(inventoryDescreased.toString());

        SagaCommand command = new SagaCommand();
        commandGateway.send(command);
    }
    @EventHandler
    //@DisallowReplay
    public void wheneverDeliveryStarted_Saga(DeliveryStartedEvent deliveryStarted){
        System.out.println(deliveryStarted.toString());

        SagaCommand command = new SagaCommand();
        commandGateway.send(command);
    }

}
