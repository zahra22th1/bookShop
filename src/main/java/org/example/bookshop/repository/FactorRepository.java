package org.example.bookshop.repository;

import org.example.bookshop.model.Factor;
import org.example.bookshop.model.Paid;
import org.example.bookshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRepository extends JpaRepository<Factor,Long> {
    Optional<Factor>findByUserAndPaid(User user, Paid paid);
}
