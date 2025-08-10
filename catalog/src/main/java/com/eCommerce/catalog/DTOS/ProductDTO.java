package com.eCommerce.catalog.DTOS;

import java.math.BigDecimal;

public record ProductDTO(String productNameDTO, String productDescriptionDTO, BigDecimal productPriceDTO, Long productQuantityDTO, Long categoryIdDTO) {
}
