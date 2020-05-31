package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.TuFiles;
import com.pavchishin.deliverychecker.service.ExcelService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public static String PATH_TU_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\TUTest";
    public static String PATH_GDN_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\GDN";
    @Autowired
    private ExcelService service;

    @GetMapping("/")
    public String showTuFiles(Map<String, Object> model){
        List<TuFiles> tuFilesList = service.getAllTuFiles();
        model.put("files", tuFilesList);
        return "index";
    }

    @PostMapping("/refresh")
    public String refreshList(Map<String, Object> model) throws IOException {
        service.deleteAll();

        List<MultipartFile> multipartTuFile = getListMultipartFiles(PATH_TU_FOLDER);
        List<MultipartFile> multipartGdnFile = getListMultipartFiles(PATH_GDN_FOLDER);

        model.put("files", multipartTuFile);
        service.saveTuFiles(multipartTuFile);
        service.saveGdnFiles(multipartGdnFile);

        return "redirect:/";
    }

    private List<MultipartFile> getListMultipartFiles(String pathTuFolder) throws IOException {
        List<MultipartFile> multipartFiles = new ArrayList<>();
        final File folder = new File(pathTuFolder);
        File [] listFiles = folder.listFiles();
        for (File fl : Objects.requireNonNull(listFiles)) {
            File file = new File(pathTuFolder + "/" + fl.getName());
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file",
                    file.getName(), "text/plain", IOUtils.toByteArray(input));
            multipartFiles.add(multipartFile);
        }
        return multipartFiles;
    }
}
