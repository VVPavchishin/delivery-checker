package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.GdnFile;
import com.pavchishin.deliverychecker.model.TuFile;
import com.pavchishin.deliverychecker.service.ExcelService;
import org.apache.poi.util.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class RefreshController {

    //@Value("${path.tu.files.folder}")
    private final String PATH_TU_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\Tu";
    //@Value("${path.gdn.files.folder}")
    private final String PATH_GDN_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\Gdn";
    private final ExcelService service;


    public RefreshController(ExcelService service) {
        this.service = service;

    }

    @GetMapping("/index")
    public String mainPage(@RequestParam(required = false) String filter, Map<String, Object> model){
        List<TuFile> tuFileList = service.getAllTuFiles();
        List<GdnFile> gdnFileList = service.getAllGdnFiles();
//        if (filter != null && filter.isEmpty()) {
//           List<TuFile> tuFiles = service.findTuFilesByDate(filter);
//            System.out.println(tuFiles);
//        }

        model.put("filesTu", tuFileList);
        model.put("filesGdn", gdnFileList);
        return "/index";
    }

    @PostMapping("index/refresh")
    public String refreshList(Map<String, Object> model) throws IOException {

        Set<String> differenceTu;
        Set<String> differenceGdn;
        Set<MultipartFile> multipartTuFile;
        Set<MultipartFile> multipartGdnFile;

        File [] listTuFiles = new File(PATH_TU_FOLDER).listFiles();
        File [] listGdnFiles = new File(PATH_GDN_FOLDER).listFiles();

        List<TuFile> filesTuList = service.getAllTuFiles();
        List<GdnFile> filesGdnList = service.getAllGdnFiles();

        Set<String> tuFileNameSetFolder = Arrays.stream(listTuFiles)
                .map(File::getName).collect(Collectors.toSet());
        Set<String> tuFileNameSetBase = filesTuList.stream()
                .map(TuFile::getOriginalTuName).collect(Collectors.toSet());


        Set<String> gdnFileNameSetFolder = Arrays.stream(listGdnFiles)
                .map(File::getName).collect(Collectors.toSet());
        Set<String> gdnFileNameSetBase = filesGdnList.stream()
                .map(GdnFile::getOriginalGdnName).collect(Collectors.toSet());

        if (tuFileNameSetFolder.size() > tuFileNameSetBase.size()) {
            differenceTu = tuFileNameSetFolder.stream()
                    .filter(el -> !tuFileNameSetBase.contains(el))
                    .collect(Collectors.toSet());
            multipartTuFile = getMultipartFiles(differenceTu, PATH_TU_FOLDER);
            service.saveTuFiles(multipartTuFile);
            model.put("filesTu", multipartTuFile);
        } else {
            model.put("filesTu", service.getAllTuFiles());
        }

        if (gdnFileNameSetFolder.size() > gdnFileNameSetBase.size()) {
            differenceGdn = gdnFileNameSetFolder.stream()
                    .filter(el -> !gdnFileNameSetBase.contains(el))
                    .collect(Collectors.toSet());
            multipartGdnFile = getMultipartFiles(differenceGdn, PATH_GDN_FOLDER);
            service.saveGdnFiles(multipartGdnFile);
            model.put("filesGdn", multipartGdnFile);
        } else {
            model.put("filesGdn", service.getAllGdnFiles());
        }

        return "redirect:/index";
    }

    private Set<MultipartFile> getMultipartFiles(Set<String> filesNames, String pathToFiles) throws IOException {
        Set<MultipartFile> multipartFiles = new HashSet<>();

        for (String fl : Objects.requireNonNull(filesNames)) {
            File file = new File(pathToFiles + "/" + fl);
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file",
                    file.getName(), "text/plain", IOUtils.toByteArray(input));
            multipartFiles.add(multipartFile);
        }
        return multipartFiles;
    }
}
