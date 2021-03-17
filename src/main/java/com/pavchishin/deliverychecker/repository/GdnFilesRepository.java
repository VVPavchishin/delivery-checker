package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.GdnFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GdnFilesRepository extends JpaRepository<GdnFile, Long> {
    List<GdnFile> findAllByTuFileId(Long id);
}
