package com.pavchishin.deliverychecker.service;

import com.pavchishin.deliverychecker.helper.ExcelHelper;
import com.pavchishin.deliverychecker.model.TuFiles;
import com.pavchishin.deliverychecker.repository.TuFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private TuFilesRepository tuFilesRepository;

    public void save(MultipartFile file) {
        try {
            List<TuFiles> tuFiles = ExcelHelper.showFiles(file);
            tuFilesRepository.saveAll(tuFiles);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<TuFiles> getAllTuFiles() {
        return tuFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "fileTuName"));
    }

    public void saveAll(List<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files) {
            List<TuFiles> tUFiles = ExcelHelper.showFiles(myFile);
            tuFilesRepository.saveAll(tUFiles);
        }
    }
    public void  deleteAll(){
        tuFilesRepository.deleteAll();
    }


}
