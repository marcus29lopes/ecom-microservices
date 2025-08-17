package com.eCommerce.cart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "cart_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long cartItemId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "cart_item_quantity")
    private Long cartItemQuantity;

    @Column(name = "cart_item_price")
    private BigDecimal cartItemPrice;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


}
