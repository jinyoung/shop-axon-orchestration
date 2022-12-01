package shop.axon.orchestration.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shop.axon.orchestration.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "orderStatuses",
    path = "orderStatuses"
)
public interface OrderStatusRepository
    extends PagingAndSortingRepository<OrderStatus, Long> {}
