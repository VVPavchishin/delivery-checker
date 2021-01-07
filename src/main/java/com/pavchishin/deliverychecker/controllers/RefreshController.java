package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.GdnFiles;
import com.pavchishin.deliverychecker.model.TuFiles;
import com.pavchishin.deliverychecker.repository.GdnFilesRepository;
import com.pavchishin.deliverychecker.repository.TuFilesRepository;
import com.pavchishin.deliverychecker.service.ExcelService;
import org.apache.poi.util.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class RefreshController {
    public final static String PATH_TU_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\TU";
    public final static String PATH_GDN_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\GDN";
    private final ExcelService service;
    private final TuFilesRepository tuFilesRepository;
    private final GdnFilesRepository gdnFilesRepository;

    public RefreshController(ExcelService service,
                             TuFilesRepository filesRepository,
                             GdnFilesRepository gdnFilesRepository) {
        this.service = service;
        this.tuFilesRepository = filesRepository;
        this.gdnFilesRepository = gdnFilesRepository;
    }

    @GetMapping("/")
    public String showTuFiles(Map<String, Object> model){
        List<TuFiles> tuFilesList = service.getAllTuFiles();
        List<GdnFiles> gdnFilesList = service.getAllGdnFiles();

        model.put("filesTu", tuFilesList);
        model.put("filesGdn", gdnFilesList);
        return "index";
    }

    @PostMapping("/refresh")
    public String refreshList(Map<String, Object> model) throws IOException {

        final File tuFolder = new File(PATH_TU_FOLDER);
        File [] listTuFiles = tuFolder.listFiles();
        List<TuFiles> filesTuList = tuFilesRepository.findAll();
        List<String> baseTuList = new ArrayList<>();
        for (TuFiles tuFiles : filesTuList) {
            baseTuList.add(tuFiles.getOriginalTuName());
        }
        List<String> filesTuNames = deleteDuplicate(Objects.requireNonNull(listTuFiles), baseTuList);

        final File gdnFolder = new File(PATH_GDN_FOLDER);
        File [] listGdnFiles = gdnFolder.listFiles();
        List<GdnFiles> filesGdnList = gdnFilesRepository.findAll();
        List<String> baseGdnList = new ArrayList<>();
        for (GdnFiles gdnFiles : filesGdnList) {
            baseGdnList.add(gdnFiles.getOriginalGdnName());
        }
        List<String> filesGdnNames = deleteDuplicate(Objects.requireNonNull(listGdnFiles), baseGdnList);


        List<MultipartFile> multipartTuFile = getListMultipartFiles(filesTuNames, PATH_TU_FOLDER);
        List<MultipartFile> multipartGdnFile = getListMultipartFiles(filesGdnNames, PATH_GDN_FOLDER);

        model.put("filesTu", multipartTuFile);
        model.put("filesGdn", multipartGdnFile);
        service.saveTuFiles(multipartTuFile);
        service.saveGdnFiles(multipartGdnFile);

        return "redirect:/";
    }

    private List<MultipartFile> getListMultipartFiles(List<String> filesNames, String pathToFiles) throws IOException {
        List<MultipartFile> multipartFiles = new ArrayList<>();

        for (String fl : Objects.requireNonNull(filesNames)) {
            File file = new File(pathToFiles + "/" + fl);
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file",
                    file.getName(), "text/plain", IOUtils.toByteArray(input));
            multipartFiles.add(multipartFile);
        }
        return multipartFiles;
    }

    private List<String> deleteDuplicate(File[] listFiles, List<String> baseList) {
        List<String> listOut = new ArrayList<>();

        if (listFiles.length > baseList.size()){
            List<String> folderList = new ArrayList<>();
            for (File file : listFiles) {
                folderList.add(file.getName());
            }

            for (String s : folderList) {
                if (!baseList.contains(s)) {
                    listOut.add(s);
                }
            }
        }
        return listOut;
    }
}
