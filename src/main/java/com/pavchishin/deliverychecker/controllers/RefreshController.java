package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.TuFiles;
import com.pavchishin.deliverychecker.service.ExcelService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public static String PATH_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\TUTest";

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

        final File folder = new File(PATH_FOLDER);
        File [] listFiles = folder.listFiles();
        List<MultipartFile> multipartFileList = new ArrayList<>();

        for (File fl : Objects.requireNonNull(listFiles)) {
            File file = new File(PATH_FOLDER + "/" + fl.getName());
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file",
                    file.getName(), "text/plain", IOUtils.toByteArray(input));
            multipartFileList.add(multipartFile);
        }

        model.put("files", multipartFileList);
        service.saveAll(multipartFileList);
        return "redirect:/";
    }
}
