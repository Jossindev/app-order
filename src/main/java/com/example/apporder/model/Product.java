package com.example.apporder.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "order")
@EqualsAndHashCode(of = "productId")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String name;

    private int price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
