package com.pavchishin.deliverychecker.controllers;

import com.pavchishin.deliverychecker.model.GdnFile;
import com.pavchishin.deliverychecker.model.PartTuFiles;
import com.pavchishin.deliverychecker.model.TuFile;
import com.pavchishin.deliverychecker.service.ExcelService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.pavchishin.deliverychecker.helper.ExcelHelper.STATUS_ACTIVE;
import static com.pavchishin.deliverychecker.helper.ExcelHelper.STATUS_PASSIVE;

@Controller
@RequestMapping("/delivery")
public class DocsController {

    private final ExcelService service;
    public DocsController(ExcelService service) {
        this.service = service;
    }

    @GetMapping("/active")
    public String showActiveDocs(Model model) {
    List<TuFile> activeFiles = service.getActiveFiles(STATUS_ACTIVE);
        model.addAttribute("filesTu", activeFiles);
        for (TuFile tuFile : activeFiles) {
            List<GdnFile> gdnFileList = service.findAllByFileId(tuFile.getId());
            model.addAttribute("gdnFiles", gdnFileList);
        }
    return "/info";
    }
}
