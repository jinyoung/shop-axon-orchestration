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
public class OrderController {

  private final CommandGateway commandGateway;
  private final QueryGateway queryGateway;

  public OrderController(CommandGateway commandGateway, QueryGateway queryGateway) {
      this.commandGateway = commandGateway;
      this.queryGateway = queryGateway;
  }

  @RequestMapping(value = "/orders",
        method = RequestMethod.POST
      )
  public CompletableFuture order(@RequestBody OrderCommand orderCommand)
        throws Exception {
      System.out.println("##### /order/order  called #####");

      // send command
      return commandGateway.send(orderCommand)            
            .thenApply(
            id -> {
                  OrderAggregate resource = new OrderAggregate();
                  BeanUtils.copyProperties(orderCommand, resource);

                  resource.setId((Long)id);
                  
                  EntityModel<OrderAggregate> model = EntityModel.of(resource);
                  model
                        .add(Link.of("/orders/" + resource.getId()).withSelfRel());

                  return new ResponseEntity<>(model, HttpStatus.OK);
            }
      );

  }


  @RequestMapping(value = "/orders",
        method = RequestMethod.DELETE
      )
  public CompletableFuture cancel(@RequestBody CancelCommand cancelCommand)
        throws Exception {
      System.out.println("##### /order/cancel  called #####");

      // send command
      return commandGateway.send(cancelCommand)            
            .thenApply(
            id -> {
                  OrderAggregate resource = new OrderAggregate();
                  BeanUtils.copyProperties(cancelCommand, resource);

                  resource.setId((Long)id);
                  
                  EntityModel<OrderAggregate> model = EntityModel.of(resource);
                  model
                        .add(Link.of("/orders/" + resource.getId()).withSelfRel());

                  return new ResponseEntity<>(model, HttpStatus.OK);
            }
      );

  }



  @RequestMapping(value = "/orders/{id}/updatestatus",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
  public CompletableFuture updateStatus(@PathVariable("id") Long id, @RequestBody UpdateStatusCommand updateStatusCommand)
        throws Exception {
      System.out.println("##### /order/updateStatus  called #####");
      updateStatusCommand.setId(id);
      // send command
      return commandGateway.send(updateStatusCommand);
  }


  @Autowired
  EventStore eventStore;

  @GetMapping(value="/orders/{id}/events")
  public ResponseEntity getEvents(@PathVariable("id") Long id){
      ArrayList resources = new ArrayList<OrderAggregate>(); 
      eventStore.readEvents(id).asStream().forEach(resources::add);

      CollectionModel<OrderAggregate> model = CollectionModel.of(resources);
                
      return new ResponseEntity<>(model, HttpStatus.OK);
  } 


}
