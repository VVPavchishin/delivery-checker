package com.pavchishin.deliverychecker.helper;

import com.pavchishin.deliverychecker.model.GdnFile;
import com.pavchishin.deliverychecker.model.PartGdnFiles;
import com.pavchishin.deliverychecker.model.PartTuFiles;
import com.pavchishin.deliverychecker.model.TuFile;
import com.pavchishin.deliverychecker.repository.PartTuRepository;
import com.pavchishin.deliverychecker.repository.TuFilesRepository;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ExcelHelper {
    public final static String STATUS_ACTIVE = "ACTIVE";
    public final static String STATUS_PASSIVE = "DISACTIVE";

    public final static String STATUS_EXPECTED = "EXPECTED";
    public final static String STATUS_DELIVERED = "DELIVERED";

    private final TuFilesRepository tuFilesRepository;
    private final PartTuRepository partTuRepository;

    public ExcelHelper(TuFilesRepository tuFilesRepository, PartTuRepository partTuRepository) {
        this.tuFilesRepository = tuFilesRepository;
        this.partTuRepository = partTuRepository;
    }

    public List<?> addAllFiles(MultipartFile file, String flag) throws IOException {

        try(XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            if (flag.equals("TU")) {
                List<TuFile> fileList = new ArrayList<>();

                String fileTuName = sheet.getRow(11).getCell(3).getStringCellValue();
                String orTuName = file.getOriginalFilename();
                Date fileTuDate = sheet.getRow(12).getCell(3).getDateCellValue();
                int rowQuantity = sheet.getLastRowNum();
                double fileTuPrice = sheet.getRow(rowQuantity - 12).getCell(6).getNumericCellValue();


                TuFile tuFile = new TuFile(orTuName, fileTuName, fileTuDate, fileTuPrice, STATUS_ACTIVE);
                int startRow = sheet.getFirstRowNum() + 14;
                int lastRow = sheet.getLastRowNum() - 15;

                for (int i = startRow; i < lastRow; i++) {
                    String codeTu = sheet.getRow(i).getCell(1).getStringCellValue();
                    String nameTu = sheet.getRow(i).getCell(2).getStringCellValue();
                    String docTu = sheet.getRow(i).getCell(3).getStringCellValue();
                    int quantityTu = (int) sheet.getRow(i).getCell(4).getNumericCellValue();
                    double priceTu = sheet.getRow(i).getCell(5).getNumericCellValue();
                    PartTuFiles partTuFiles = new PartTuFiles(codeTu, nameTu,
                            docTu, quantityTu, priceTu, STATUS_EXPECTED);
                    tuFile.setPartTuFile(partTuFiles);
                }
                fileList.add(tuFile);
                return fileList;
            } else {
                List<GdnFile> fileList = new ArrayList<>();

                String fileGdnName = sheet.getRow(15).getCell(4).getStringCellValue();
                String orGdnName = file.getOriginalFilename();
                Date fileGdnDate = sheet.getRow(16).getCell(4).getDateCellValue();
                int rowQuantity = sheet.getLastRowNum();
                double fileGdnPrice = sheet.getRow(rowQuantity - 10).getCell(6).getNumericCellValue();
                String fileTuName = sheet.getRow(11).getCell(2).getStringCellValue();

                TuFile fileInGdn = tuFilesRepository.findByFileTuName(fileTuName);

                GdnFile fileGdn = new GdnFile(orGdnName, fileGdnName, fileGdnDate, fileGdnPrice, fileInGdn);

                int startRow = sheet.getFirstRowNum() + 19;
                int lastRow = sheet.getLastRowNum() - 13;
                for (int i = startRow; i < lastRow; i++) {
                    String codeGdnPart = sheet.getRow(i).getCell(1).getStringCellValue();
                    String nameGdnPart = sheet.getRow(i).getCell(2).getStringCellValue();
                    int quantityGdnPart = (int) sheet.getRow(i).getCell(4).getNumericCellValue();
                    double priceGdnPart = sheet.getRow(i).getCell(5).getNumericCellValue();
                    String placeGdnPart = sheet.getRow(i).getCell(7).getStringCellValue();
                    String dosGdnPart = sheet.getRow(i).getCell(11).getStringCellValue();

                    PartGdnFiles partGdnFiles = new PartGdnFiles(codeGdnPart, nameGdnPart,
                            quantityGdnPart, priceGdnPart, placeGdnPart, dosGdnPart);

                    fileGdn.setPartGdnFile(partGdnFiles);
                }
                fileList.add(fileGdn);
                return fileList;
            }
        }
    }
}
