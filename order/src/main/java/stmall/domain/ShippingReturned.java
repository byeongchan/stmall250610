package stmall.domain;

import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

@Data
@ToString
public class ShippingReturned extends AbstractEvent {

    private Long id;
    private Long orderid;
    private String customerid;
    private String itemid;
    private Integer qty;
    private String address;
}
