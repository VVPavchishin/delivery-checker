package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.GdnFiles;
import com.pavchishin.deliverychecker.model.TuFiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface GdnFilesRepository extends JpaRepository<GdnFiles, Long> {
}
