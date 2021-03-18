package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.TuFile;
import com.pavchishin.deliverychecker.service.ExcelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DocsController {

    private final ExcelService service;
    public DocsController(ExcelService service) {
        this.service = service;
    }

    @GetMapping("/active")
    public String showActiveDocs() {
        List<TuFile> tuFiles = service.getAllTuFiles();

        return "/info";
    }
}
