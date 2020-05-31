package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.GdnFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GdnFilesRepository extends JpaRepository<GdnFiles, Long> {
}
