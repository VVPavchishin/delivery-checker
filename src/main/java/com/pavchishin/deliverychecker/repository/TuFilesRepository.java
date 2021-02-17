package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.TuFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuFilesRepository extends JpaRepository<TuFile, Long> {
    TuFile findByFileTuName(String fileTuName);

    List<TuFile> findAllByFileTuDate(String date);
}
