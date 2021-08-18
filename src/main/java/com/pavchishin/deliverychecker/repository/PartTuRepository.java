package com.pavchishin.deliverychecker.repository;

import com.pavchishin.deliverychecker.model.PartTuFiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartTuRepository extends JpaRepository<PartTuFiles, Long> {
    List<PartTuFiles> findAllByTuFileId(long id);

    List<PartTuFiles> findAllByPartTuStatus(String status);
}
