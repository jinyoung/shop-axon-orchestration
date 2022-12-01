package shop.axon.orchestration.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import shop.axon.orchestration.InventoryApplication;
import shop.axon.orchestration.domain.InventoryDescreased;
import shop.axon.orchestration.domain.InventoryIncreased;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        InventoryDescreased inventoryDescreased = new InventoryDescreased(this);
        inventoryDescreased.publishAfterCommit();

        InventoryIncreased inventoryIncreased = new InventoryIncreased(this);
        inventoryIncreased.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }
}
