package com.pavchishin.deliverychecker.service;

import com.pavchishin.deliverychecker.helper.ExcelHelper;
import com.pavchishin.deliverychecker.model.GdnFile;
import com.pavchishin.deliverychecker.model.SparePart;
import com.pavchishin.deliverychecker.model.TuFile;
import com.pavchishin.deliverychecker.repository.GdnFilesRepository;
import com.pavchishin.deliverychecker.repository.SparePartRepository;
import com.pavchishin.deliverychecker.repository.TuFilesRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    private final TuFilesRepository tuFilesRepository;
    private final GdnFilesRepository gdnFilesRepository;
    private final SparePartRepository partRepository;

    private final ExcelHelper helper;

    public ExcelService(TuFilesRepository tuFilesRepository,
                        GdnFilesRepository gdnFilesRepository,
                        SparePartRepository partRepository, ExcelHelper helper) {
        this.tuFilesRepository = tuFilesRepository;
        this.gdnFilesRepository = gdnFilesRepository;
        this.partRepository = partRepository;
        this.helper = helper;
    }
    public List<TuFile> getAllTuFiles() {
        return tuFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "fileTuName"));
    }
    public List<GdnFile> getAllGdnFiles() {
        return gdnFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "fileGdnName"));
    }
    public void saveTuFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files) {
            List<TuFile> tUFiles = helper.addTuFiles(myFile);
            tuFilesRepository.saveAll(tUFiles);
        }
    }
    public void saveGdnFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files) {
            List<GdnFile> gdnFiles = helper.addGdnFiles(myFile);
            gdnFilesRepository.saveAll(gdnFiles);
        }
    }
    public void saveSparePart(List<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files){
            List<SparePart> spareParts = helper.addSparePart(myFile);
            partRepository.saveAll(spareParts);
        }
    }
}
