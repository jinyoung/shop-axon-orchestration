package shop.axon.orchestration.query;

import org.springframework.hateoas.server.core.Relation;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="OrderStatus_table")
@Data
@Relation(collectionRelation = "orderStatuses")
public class OrderStatus {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String status;
        private Double amount;
        private Long qty;
        private String productId;


}
