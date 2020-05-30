package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.TuFiles;
import com.pavchishin.deliverychecker.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ExcelService service;

    @GetMapping
    public String mainPage(){
        return "index";
    }

    @GetMapping("/list-files")
    public String showTuFiles(Map<String, Object> model){
        List<TuFiles> tuFilesList = service.getAllTuFiles();
        if (tuFilesList.isEmpty()) {
            System.out.println("Empty file!!!");
        }
        model.put("files", tuFilesList);
        return "list-files";
    }

    @GetMapping("/load-excel")
    public String loadPage(){
        return "load-excel";
    }

//    @PostMapping("/load-excel")
//    public String loadExcel(@RequestParam("file") MultipartFile file, ModelMap modelMap){
//        modelMap.addAttribute("file", file);
//        service.save(file);
//        return "redirect:/list-files";
//    }

}
