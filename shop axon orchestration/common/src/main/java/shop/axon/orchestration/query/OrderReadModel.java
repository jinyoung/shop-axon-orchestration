package shop.axon.orchestration.query;

import org.springframework.hateoas.server.core.Relation;

import javax.persistence.*;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="OrderStatus_table")
@Data
@Relation(collectionRelation = "orderStatuses")
public class OrderReadModel {

        @Id
        private Long id;
        private String productId;
        private Integer qty;
        private String customerId;
        private BigDecimal amount;
        private String status;
        private String address;

}
