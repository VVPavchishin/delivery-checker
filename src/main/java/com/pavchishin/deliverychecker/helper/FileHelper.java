package com.pavchishin.deliverychecker.helper;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileHelper {

    private final String PATH_TU_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\TuTest";
    private final String PATH_GDN_FOLDER =
            "C:\\Users\\User\\OneDrive - ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ «САМІТ МОТОРЗ УКРАЇНА»\\GdnTest";
    private final String TEMP_FOLDER = "C:\\Users\\User\\Temp";

    public void checkFolder() {
        Path path = Paths.get(TEMP_FOLDER);
        if (Files.exists(path)) {
            Set<String> tempFileNames = checkFiles(TEMP_FOLDER);
            tempFileNames.addAll(checkFiles(PATH_TU_FOLDER));


        } else {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Set<String> checkFiles(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory() && file.getName().endsWith(".xlsx"))
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}
