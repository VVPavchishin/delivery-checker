package com.pavchishin.deliverychecker.helper;

import com.pavchishin.deliverychecker.model.GdnFiles;
import com.pavchishin.deliverychecker.model.TuFiles;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ExcelHelper {
    public static String STATUS_ACTIVE = "ACTIVE";
    public static String STATUS_PASSIVE = "PASSIVE";

    public static List<TuFiles> showTuFiles(MultipartFile file) throws IOException {

        List<TuFiles> tuFiles = new ArrayList<TuFiles>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        String fileName = sheet.getRow(11).getCell(3).getStringCellValue();
        Date fileDate = sheet.getRow(12).getCell(3).getDateCellValue();
        int rowQuantity = sheet.getLastRowNum();
        double filePrice = sheet.getRow(rowQuantity - 12).getCell(6).getNumericCellValue();

        TuFiles files = new TuFiles();
        String orName = file.getOriginalFilename();
        files.setOriginalTuName(orName);
        files.setFileTuName(fileName);
        files.setFileTuDate(fileDate);
        files.setFileTuPrice(filePrice);
        files.setStatus(STATUS_ACTIVE);
        tuFiles.add(files);

        return tuFiles;
    }

    public static List<GdnFiles> showGdnFiles(MultipartFile file) throws IOException {
        List<GdnFiles> gdnFiles = new ArrayList<GdnFiles>();

        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        String orGdnName = file.getOriginalFilename();
        String fileGdnName = sheet.getRow(15).getCell(4).getStringCellValue();
        Date fileGdnDate = sheet.getRow(16).getCell(4).getDateCellValue();
        int rowQuantity = sheet.getLastRowNum();
        double fileGdnPrice = sheet.getRow(rowQuantity - 10).getCell(6).getNumericCellValue();
        String fileTuName = sheet.getRow(11).getCell(2).getStringCellValue();

        GdnFiles fileGdn = new GdnFiles();
        fileGdn.setOriginalGdnName(orGdnName);
        fileGdn.setFileGdnName(fileGdnName);
        fileGdn.setFileGdnDate(fileGdnDate);
        fileGdn.setFileGdnPrice(fileGdnPrice);
//        fileGdn.setTuFiles();!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        return gdnFiles;
    }
}
