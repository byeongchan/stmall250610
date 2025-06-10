package stmall.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import stmall.DeliveryApplication;
import stmall.domain.DeliverCompleted;
import stmall.domain.ShippingReturned;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderid;

    private String customerid;

    private String itemid;

    private Integer qty;

    private String address;

    private String status;

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        //implement business logic here:

        Delivery delivery = new Delivery();
        delivery.setOrderid(orderPlaced.getId());
        delivery.setItemid(orderPlaced.getItemid());
        delivery.setAddress(orderPlaced.getAddress());
        delivery.setCustomerid(orderPlaced.getCustomerid());
        delivery.setQty(orderPlaced.getQty());
        delivery.setStatus("DELIVERY COMPLETED");
        repository().save(delivery);

        DeliverCompleted deliverCompleted = new DeliverCompleted(delivery);
        deliverCompleted.publishAfterCommit();

        /** Example 2:  finding and process
        

        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliverCompleted deliverCompleted = new DeliverCompleted(delivery);
            deliverCompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        ShippingReturned shippingReturned = new ShippingReturned(delivery);
        shippingReturned.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderCanceled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            ShippingReturned shippingReturned = new ShippingReturned(delivery);
            shippingReturned.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
