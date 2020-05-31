package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.TuFiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TuFilesRepository extends JpaRepository<TuFiles, Long> {
    List<TuFiles> findByFileTuName(String name);
}
