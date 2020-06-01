package com.pavchishin.deliverychecker.service;

import com.pavchishin.deliverychecker.helper.ExcelHelper;
import com.pavchishin.deliverychecker.model.GdnFiles;
import com.pavchishin.deliverychecker.model.TuFiles;
import com.pavchishin.deliverychecker.repository.GdnFilesRepository;
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

    @Autowired
    private GdnFilesRepository gdnFilesRepository;

    @Autowired
    private ExcelHelper helper;

    public void save(MultipartFile file) {
        try {
            List<TuFiles> tuFiles = helper.showTuFiles(file);
            tuFilesRepository.saveAll(tuFiles);
        } catch (IOException e) {
            throw new RuntimeException("Fail to store excel data: " + e.getMessage());
        }
    }

    public List<TuFiles> getAllTuFiles() {
        return tuFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "fileTuName"));
    }
    public List<GdnFiles> getAllGdnFiles() {
        return gdnFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "tuFiles"));
    }

    public void saveTuFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files) {
            List<TuFiles> tUFiles = helper.showTuFiles(myFile);
            tuFilesRepository.saveAll(tUFiles);
        }
    }
    public void saveGdnFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files) {
            List<GdnFiles> gdnFiles = helper.showGdnFiles(myFile);
            gdnFilesRepository.saveAll(gdnFiles);
        }
    }
    public void  deleteAll(){
        tuFilesRepository.deleteAll();
        gdnFilesRepository.deleteAll();
    }


}
