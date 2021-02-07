package com.pavchishin.deliverychecker.service;

import com.pavchishin.deliverychecker.helper.ExcelHelper;
import com.pavchishin.deliverychecker.model.GdnFile;
import com.pavchishin.deliverychecker.model.PartTuFiles;
import com.pavchishin.deliverychecker.model.TuFile;
import com.pavchishin.deliverychecker.repository.GdnFilesRepository;
import com.pavchishin.deliverychecker.repository.PartTuRepository;
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
    private final PartTuRepository partRepository;

    private final ExcelHelper helper;


    public ExcelService(TuFilesRepository tuFilesRepository,
                        GdnFilesRepository gdnFilesRepository,
                        PartTuRepository partRepository,
                        ExcelHelper helper) {
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
            List<? extends TuFile> tUFiles = (List<? extends TuFile>) helper.addAllFiles(myFile, "TU");
            tuFilesRepository.saveAll(tUFiles);
        }
    }
    public void saveGdnFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files) {
            List<? extends GdnFile> gdnFiles = (List<? extends GdnFile>) helper.addAllFiles(myFile, "GDN");
            gdnFilesRepository.saveAll(gdnFiles);
        }
    }
//    public void savePartFromTu(List<MultipartFile> files) throws IOException {
//        for (MultipartFile myFile : files){
//            List<PartTuFiles> spareParts = helper.addPartTuFile(myFile);
//            partRepository.saveAll(spareParts);
//        }
//    }
//    public void savePartFromGdn(List<MultipartFile> files) throws IOException {
//        for (MultipartFile myFile : files){
//            List<PartTuFiles> spareParts = helper.addPartGdnFile(myFile);
//            //partRepository.saveAll(spareParts);
//        }
//    }
}
