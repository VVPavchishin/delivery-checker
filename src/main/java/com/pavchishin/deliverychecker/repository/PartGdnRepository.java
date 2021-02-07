package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.PartGdnFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartGdnRepository extends JpaRepository<PartGdnFiles, Long> {
}
