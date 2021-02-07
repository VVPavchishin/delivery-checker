package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.PartTuFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartTuRepository extends JpaRepository<PartTuFiles, Long> {
}
