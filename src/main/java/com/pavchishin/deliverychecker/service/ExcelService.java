package com.pavchishin.deliverychecker.service;

import com.pavchishin.deliverychecker.helper.ExcelHelper;
import com.pavchishin.deliverychecker.model.GdnFiles;
import com.pavchishin.deliverychecker.model.TuFiles;
import com.pavchishin.deliverychecker.repository.GdnFilesRepository;
import com.pavchishin.deliverychecker.repository.TuFilesRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {

    private final TuFilesRepository tuFilesRepository;

    private final GdnFilesRepository gdnFilesRepository;

    private final ExcelHelper helper;

    public ExcelService(TuFilesRepository tuFilesRepository,
                        GdnFilesRepository gdnFilesRepository,
                        ExcelHelper helper) {
        this.tuFilesRepository = tuFilesRepository;
        this.gdnFilesRepository = gdnFilesRepository;
        this.helper = helper;
    }
    public List<TuFiles> getAllTuFiles() {
        return tuFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "fileTuName"));
    }
    public List<GdnFiles> getAllGdnFiles() {
        return gdnFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "fileGdnName"));
    }
    public List<String> getAllTuFilesName(){
        List<TuFiles> tuFiles = tuFilesRepository.findAll();
        List<String> nameList = new ArrayList<>();
        for (TuFiles files : tuFiles) {
            nameList.add(files.getFileTuName());
        }
        return nameList;
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
