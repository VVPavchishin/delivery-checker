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

    @GetMapping
    public String mainPage(){
        return "index";
    }


}
