package org.example.bookshop.repository;

import org.example.bookshop.model.Factor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactorRepository extends JpaRepository<Factor,Long> {
}
