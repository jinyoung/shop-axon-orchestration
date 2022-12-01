package shop.axon.orchestration.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.axonframework.eventsourcing.eventstore.EventStore;

import org.springframework.beans.BeanUtils;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;

import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;


import shop.axon.orchestration.aggregate.*;
import shop.axon.orchestration.command.*;

@RestController
public class DeliveryController {

  private final CommandGateway commandGateway;
  private final QueryGateway queryGateway;

  public DeliveryController(CommandGateway commandGateway, QueryGateway queryGateway) {
      this.commandGateway = commandGateway;
      this.queryGateway = queryGateway;
  }


  @RequestMapping(value = "/deliveries/{id}/returndelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
  public CompletableFuture returnDelivery(@PathVariable("id") Long id, @RequestBody ReturnDeliveryCommand returnDeliveryCommand)
        throws Exception {
      System.out.println("##### /delivery/returnDelivery  called #####");
      returnDeliveryCommand.setId(id);
      // send command
      return commandGateway.send(returnDeliveryCommand);
  }

  @RequestMapping(value = "/deliveries",
        method = RequestMethod.POST
      )
  public CompletableFuture addToDeliveryList(@RequestBody AddToDeliveryListCommand addToDeliveryListCommand)
        throws Exception {
      System.out.println("##### /delivery/addToDeliveryList  called #####");

      // send command
      return commandGateway.send(addToDeliveryListCommand)            
            .thenApply(
            id -> {
                  DeliveryAggregate resource = new DeliveryAggregate();
                  BeanUtils.copyProperties(addToDeliveryListCommand, resource);

                  resource.setId((Long)id);
                  
                  EntityModel<DeliveryAggregate> model = EntityModel.of(resource);
                  model
                        .add(Link.of("/deliveries/" + resource.getId()).withSelfRel());

                  return new ResponseEntity<>(model, HttpStatus.OK);
            }
      );

  }



  @Autowired
  EventStore eventStore;

  @GetMapping(value="/deliveries/{id}/events")
  public ResponseEntity getEvents(@PathVariable("id") Long id){
      ArrayList resources = new ArrayList<DeliveryAggregate>(); 
      eventStore.readEvents(id).asStream().forEach(resources::add);

      CollectionModel<DeliveryAggregate> model = CollectionModel.of(resources);
                
      return new ResponseEntity<>(model, HttpStatus.OK);
  } 


}
