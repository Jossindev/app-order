package com.example.apporder.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "orderId")
@Entity(name = "custom_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "order_has_products",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> products;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", products=" + products +
                '}';
    }
}
