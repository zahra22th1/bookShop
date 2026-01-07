package org.example.bookshop.shippingcard;

import org.example.bookshop.dto.response.ShoppingCardResponse;
import org.example.bookshop.dto.resquest.ShoppingCardRequest;

public interface ShoppingCardService {
    ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest);
}
