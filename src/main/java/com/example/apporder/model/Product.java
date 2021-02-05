package com.example.apporder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "productId")
@ToString(exclude = "orders")
@JsonIgnoreProperties({"orders"})
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}
