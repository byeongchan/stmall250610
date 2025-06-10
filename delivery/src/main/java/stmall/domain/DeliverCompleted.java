package stmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliverCompleted extends AbstractEvent {

    private Long id;
    private Long orderid;
    private String customerid;
    private String itemid;
    private Integer qty;
    private String address;

    public DeliverCompleted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliverCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
