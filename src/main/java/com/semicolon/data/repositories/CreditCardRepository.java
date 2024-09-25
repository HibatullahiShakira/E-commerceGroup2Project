package com.semicolon.data.repositories;

import com.semicolon.data.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
