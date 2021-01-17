package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartRepository extends JpaRepository<SparePart, Long> {
}
