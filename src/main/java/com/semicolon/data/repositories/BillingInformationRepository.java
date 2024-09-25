package com.semicolon.data.repositories;

import com.semicolon.data.model.BillingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingInformationRepository extends JpaRepository<BillingInformation, Long> {
}
