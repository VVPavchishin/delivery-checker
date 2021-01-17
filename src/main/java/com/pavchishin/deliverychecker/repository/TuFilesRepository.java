package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.TuFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuFilesRepository extends JpaRepository<TuFile, Long> {
    TuFile findByFileTuName(String name);
}
