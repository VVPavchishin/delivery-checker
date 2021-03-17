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
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class ExcelService {

    private final TuFilesRepository tuFilesRepository;
    private final GdnFilesRepository gdnFilesRepository;
    private final PartTuRepository partTuRepository;

    private final ExcelHelper helper;


    public ExcelService(TuFilesRepository tuFilesRepository,
                        GdnFilesRepository gdnFilesRepository,
                        PartTuRepository partTuRepository,
                        ExcelHelper helper) {
        this.tuFilesRepository = tuFilesRepository;
        this.gdnFilesRepository = gdnFilesRepository;
        this.partTuRepository = partTuRepository;
        this.helper = helper;
    }
    public List<TuFile> getAllTuFiles() {
        return tuFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "fileTuName"));
    }
    public List<GdnFile> getAllGdnFiles() {
        return gdnFilesRepository.findAll(Sort.by(Sort.Direction.DESC, "fileGdnName"));
    }
    public void saveTuFiles(Set<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files) {
            List<? extends TuFile> tUFiles = (List<? extends TuFile>) helper.addAllFiles(myFile, "TU");
            tuFilesRepository.saveAll(tUFiles);
        }
    }
    public void saveGdnFiles(Set<MultipartFile> files) throws IOException {
        for (MultipartFile myFile : files) {
            List<? extends GdnFile> gdnFiles = (List<? extends GdnFile>) helper.addAllFiles(myFile, "GDN");
            gdnFilesRepository.saveAll(gdnFiles);
        }
    }

    public List<TuFile> findTuFilesByDate(String date) {
        List<TuFile> tuFileList = tuFilesRepository.findAllByFileTuDate(date);
        return tuFileList;
    }

    public TuFile findTuFileByName(String name) {
        return tuFilesRepository.findByFileTuName(name);
    }

    public List<PartTuFiles> findAllByTuFileId(Long id) {
        return partTuRepository.findAllByTuFileId(id);
    }
    public List<GdnFile> findAllByFileId(Long id){
        return gdnFilesRepository.findAllByTuFileId(id);
    }
}
