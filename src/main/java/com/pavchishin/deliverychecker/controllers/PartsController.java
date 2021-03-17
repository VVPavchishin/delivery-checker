package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.GdnFile;
import com.pavchishin.deliverychecker.model.PartTuFiles;
import com.pavchishin.deliverychecker.model.TuFile;
import com.pavchishin.deliverychecker.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PartsController {

    private final ExcelService service;
    public PartsController(ExcelService service) {
        this.service = service;
    }

    @GetMapping("/parts")
    public String showPartsPage(){
        return "parts-list";
    }


    @PostMapping("/parts")
    public String showParts (@RequestParam("tuName") String tuName, Model model) {
        TuFile tuFile = service.findTuFileByName(tuName);
        model.addAttribute("tuFile", tuFile);

        List<PartTuFiles> partTuFiles = service.findAllByTuFileId(tuFile.getId());
        model.addAttribute("parts", partTuFiles);

        List<GdnFile> gdnFileList = service.findAllByFileId(tuFile.getId());
        model.addAttribute("gdnFiles", gdnFileList);

        return "parts-list";
    }
    @PostMapping("/back")
    public String returnBack(){

        return "redirect:/index";
    }

}
