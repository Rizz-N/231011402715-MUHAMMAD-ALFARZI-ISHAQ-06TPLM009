package com.api.pos.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customer_name;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime order_date;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> order_items;

    @PrePersist
    public void prePersist() {
        this.order_date = LocalDateTime.now();
    }
}

