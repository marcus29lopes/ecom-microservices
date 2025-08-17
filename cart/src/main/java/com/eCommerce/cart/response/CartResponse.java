package com.eCommerce.cart.response;

import com.eCommerce.cart.model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {

    private BigDecimal cartTotal;

    private List<CartItem> cartItems;
}
