package com.pavchishin.deliverychecker.helper;

import com.pavchishin.deliverychecker.model.TuFiles;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static String STATUS_ACTIVE = "ACTIVE";

    public static List<TuFiles> showFiles(MultipartFile file) throws IOException {

        List<TuFiles> tuFiles = new ArrayList<TuFiles>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        String fileName = sheet.getRow(11).getCell(3).getStringCellValue();
        Date fileDate = sheet.getRow(12).getCell(3).getDateCellValue();
        int rowQuantity = sheet.getLastRowNum();
        double filePrice = sheet.getRow(rowQuantity - 12).getCell(6).getNumericCellValue();

        TuFiles files = new TuFiles();
        String orName = file.getOriginalFilename();
        System.out.print(orName + " >>> ");
        files.setOriginalTuName(orName);
        files.setFileTuName(fileName);
        System.out.print(fileName + " >>> ");
        files.setFileTuDate(fileDate);
        System.out.print(fileDate + " >>> ");
        files.setFileTuPrice(filePrice);
        System.out.print(filePrice + " >>> ");
        files.setStatus(STATUS_ACTIVE);
        System.out.println(STATUS_ACTIVE);

        tuFiles.add(files);
        return tuFiles;
    }
}
