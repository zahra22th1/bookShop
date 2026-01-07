package org.example.bookshop.controller;

import jakarta.validation.Valid;
import org.example.bookshop.dto.response.ShoppingCardResponse;
import org.example.bookshop.dto.resquest.ShoppingCardRequest;
import org.example.bookshop.model.ShoppingCard;
import org.example.bookshop.shippingcard.ShoppingCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcard")

public class ShoppingCardController {
   private final ShoppingCardService shoppingCardService;

    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }

    //end point (API)
    @PostMapping
    public ResponseEntity<ShoppingCardResponse> addBook(@RequestBody @Valid ShoppingCardRequest shoppingCardRequest) {
       return    ResponseEntity.ok(shoppingCardService.addShoppingCard(shoppingCardRequest));
    }
}
