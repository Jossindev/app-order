package com.example.apporder.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "orderId")
@Entity(name = "custom_orders")
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "order_has_products",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Order() {
        this.status = Status.NOT_SENT;
    }
}
