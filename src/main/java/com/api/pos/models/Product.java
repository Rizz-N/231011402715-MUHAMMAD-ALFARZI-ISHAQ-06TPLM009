package com.api.pos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(nullable = false)
private String name;

@Column(precision =  15, scale = 2)
private BigDecimal price;

private Integer quantity;

@ManyToOne
@JoinColumn(name = "category_id")
private Category category;
}
