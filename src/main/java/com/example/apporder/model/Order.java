package com.example.apporder.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "orderId")
@Entity(name = "customOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToMany(mappedBy = "order")
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }
}
