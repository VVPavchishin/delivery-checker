package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.GdnFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GdnFilesRepository extends JpaRepository<GdnFile, Long> {
}
