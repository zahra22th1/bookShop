package org.example.bookshop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
public class ShoppingCardResponse {
    private final Long shoppingCardId;
    private final Long factorId;
}
