package shop.axon.orchestration.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import shop.axon.orchestration.query.*;

@RestController
public class OrderStatusQueryController {

    private final QueryGateway queryGateway;

    public OrderStatusQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/orderStatuses")
    public CompletableFuture findAll() {
        return queryGateway
            .query(
                new OrderStatusQuery(),
                ResponseTypes.multipleInstancesOf(OrderStatus.class)
            )
            .thenApply(resources -> {
                CollectionModel<OrderStatus> model = CollectionModel.of(
                    resources
                );

                return new ResponseEntity<>(model, HttpStatus.OK);
            });
    }

    @GetMapping("/orderStatuses/{id}")
    public CompletableFuture findById(@PathVariable("id") Long id) {
        OrderStatusSingleQuery query = new OrderStatusSingleQuery();
        query.setId(id);

        return queryGateway
            .query(query, ResponseTypes.optionalInstanceOf(OrderStatus.class))
            .thenApply(resource -> {
                if (!resource.isPresent()) {
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }

                EntityModel<OrderStatus> model = EntityModel.of(resource.get());
                model.add(
                    Link
                        .of("/orderStatuses/" + resource.get().getId())
                        .withSelfRel()
                );

                return new ResponseEntity<>(model, HttpStatus.OK);
            })
            .exceptionally(ex -> {
                throw new RuntimeException(ex);
            });
    }
}
