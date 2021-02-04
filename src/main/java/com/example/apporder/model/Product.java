package com.example.apporder.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "order")
@EqualsAndHashCode(of = "productId")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @ManyToMany
    @JoinColumn(name = "order_id")
    private List<Order> order;

    public Product(String name) {
        this.name = name;
    }
}
