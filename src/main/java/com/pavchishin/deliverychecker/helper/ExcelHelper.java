package com.pavchishin.deliverychecker.helper;

import com.pavchishin.deliverychecker.model.TuFiles;
import com.pavchishin.deliverychecker.repository.TuFilesRepository;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static String STATUS_ACTIVE = "ACTIVE";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<TuFiles> showFiles(InputStream is, MultipartFile file) throws IOException {

        List<TuFiles> tuFiles = new ArrayList<TuFiles>();
        XSSFWorkbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);

        String fileName = sheet.getRow(11).getCell(3).getStringCellValue();
        Date fileDate = sheet.getRow(12).getCell(3).getDateCellValue();
        System.out.println(fileName + "   " + fileDate);
        int rowQuantity = sheet.getLastRowNum();
        double filePrice = sheet.getRow(rowQuantity - 12).getCell(6).getNumericCellValue();

        TuFiles files = new TuFiles();
        String orName = file.getOriginalFilename();
        System.out.println(orName);
        files.setOriginalTuName(orName);
        files.setFileTuName(fileName);
        files.setFileTuDate(fileDate);
        files.setFileTuPrice(filePrice);
        files.setStatus(STATUS_ACTIVE);

        tuFiles.add(files);
        return tuFiles;
    }
}
