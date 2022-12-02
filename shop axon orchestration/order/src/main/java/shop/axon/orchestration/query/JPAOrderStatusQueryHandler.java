package shop.axon.orchestration.query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.axon.orchestration.aggregate.OrderAggregate;
import shop.axon.orchestration.event.*;

@Service
@ProcessingGroup("orderStatus")
public class JPAOrderStatusQueryHandler {

    //<<< EDA / CQRS
    @Autowired
    private OrderReadModelRepository repository;

    @QueryHandler
    public List<OrderReadModel> handle(OrderReadModelQuery query) {
        return repository.findAll();
    }

    @QueryHandler
    public Optional<OrderReadModel> handle(OrderReadModelSingleQuery query) {
        return repository.findById(query.getId());
    }

    @EventHandler
    public void whenOrderPlaced_then_CREATE(OrderPlacedEvent event)
        throws Exception {
        OrderReadModel entity = new OrderReadModel();
        OrderAggregate aggregate = new OrderAggregate();
        aggregate.on(event);

        BeanUtils.copyProperties(aggregate, entity);

        repository.save(entity);
    }


    @EventHandler
    public void whenOrderCancelled_then_UPDATE(OrderCancelledEvent event)
        throws Exception {
        repository
            .findById(event.getId())
            .ifPresent(entity -> {
                OrderAggregate aggregate = new OrderAggregate();

                BeanUtils.copyProperties(entity, aggregate);
                aggregate.on(event);
                BeanUtils.copyProperties(aggregate, entity);

                repository.save(entity);
            });
    }

    @EventHandler
    public void whenOrderDeliveryStarted_then_UPDATE(
        OrderDeliveryStartedEvent event
    ) throws Exception {
        repository
            .findById(event.getId())
            .ifPresent(entity -> {
                OrderAggregate aggregate = new OrderAggregate();

                BeanUtils.copyProperties(entity, aggregate);
                aggregate.on(event);
                BeanUtils.copyProperties(aggregate, entity);

                repository.save(entity);
            });
    }
    //>>> EDA / CQRS
}
