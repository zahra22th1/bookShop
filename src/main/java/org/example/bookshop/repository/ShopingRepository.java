package org.example.bookshop.repository;

import org.example.bookshop.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopingRepository extends JpaRepository<ShoppingCard,Long> {

}
