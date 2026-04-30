package com.api.pos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String payment_method;

    @Column(precision = 12, scale = 2)
    private BigDecimal amount;

    private String payment_status;

    @CreationTimestamp
    private LocalDateTime paid_at;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
