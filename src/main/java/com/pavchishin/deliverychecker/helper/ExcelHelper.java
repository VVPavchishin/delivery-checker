package com.pavchishin.deliverychecker.helper;

import com.pavchishin.deliverychecker.model.GdnFile;
import com.pavchishin.deliverychecker.model.SparePart;
import com.pavchishin.deliverychecker.model.TuFile;
import com.pavchishin.deliverychecker.repository.TuFilesRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Service
public class ExcelHelper {
    public final static String STATUS_ACTIVE = "ACTIVE";
    //public final static String STATUS_PASSIVE = "DISACTIVE";

    private final TuFilesRepository tuFilesRepository;

    public ExcelHelper(TuFilesRepository tuFilesRepository) {
        this.tuFilesRepository = tuFilesRepository;
    }


    public List<TuFile> addTuFiles(MultipartFile file) throws IOException {
        addSparePart(file);
        List<TuFile> tuFiles = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        String fileName = sheet.getRow(11).getCell(3).getStringCellValue();
        Date fileDate = sheet.getRow(12).getCell(3).getDateCellValue();
        int rowQuantity = sheet.getLastRowNum();
        double filePrice = sheet.getRow(rowQuantity - 12).getCell(6).getNumericCellValue();

        TuFile files = new TuFile();
        String orName = file.getOriginalFilename();
        files.setOriginalTuName(orName);
        files.setFileTuName(fileName);
        files.setFileTuDate(fileDate);
        files.setFileTuPrice(filePrice);
        files.setStatus(STATUS_ACTIVE);

        tuFiles.add(files);

        return tuFiles;
    }

    public List<GdnFile> addGdnFiles(MultipartFile file) throws IOException {
        List<GdnFile> gdnFiles = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        String orGdnName = file.getOriginalFilename();
        String fileGdnName = sheet.getRow(15).getCell(4).getStringCellValue();
        Date fileGdnDate = sheet.getRow(16).getCell(4).getDateCellValue();
        int rowQuantity = sheet.getLastRowNum();
        double fileGdnPrice = sheet.getRow(rowQuantity - 10).getCell(6).getNumericCellValue();
        String fileTuName = sheet.getRow(11).getCell(2).getStringCellValue();

        GdnFile fileGdn = new GdnFile();
        fileGdn.setOriginalGdnName(orGdnName);
        fileGdn.setFileGdnName(fileGdnName);
        fileGdn.setFileGdnDate(fileGdnDate);
        fileGdn.setFileGdnPrice(fileGdnPrice);
        fileGdn.setTuFile(tuFilesRepository.findByFileTuName(fileTuName));
        gdnFiles.add(fileGdn);
        return gdnFiles;
    }

    public List<SparePart> addSparePart(MultipartFile file) throws IOException{
        List<SparePart> partList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        int startRow = sheet.getFirstRowNum() + 14;
        int lastRow = sheet.getLastRowNum() - 15;
        String fileName = sheet.getRow(11).getCell(3).getStringCellValue();

        for (int i = startRow; i < lastRow; i++) {
            String code = sheet.getRow(i).getCell(1).getStringCellValue();
            String name = sheet.getRow(i).getCell(2).getStringCellValue();
            int quantity = (int) sheet.getRow(i).getCell(4).getNumericCellValue();
            double price = sheet.getRow(i).getCell(5).getNumericCellValue();

            SparePart sparePart = new SparePart(code, name, quantity,
                    price, tuFilesRepository.findByFileTuName(fileName));
            partList.add(sparePart);
        }
        return partList;
    }
}
