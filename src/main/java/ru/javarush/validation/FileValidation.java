package ru.javarush.validation;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileValidation {
    private static final List<String> FORBIDDEN_FILE_EXTENSIONS =
            new ArrayList<>(Arrays.asList("bin","htaccess","bash_profile"));

    public static boolean acceptOutput(Path path) {
        Path absPath = path.toAbsolutePath();
        String fileExtension = FilenameUtils.getExtension(path.toString());
        if(absPath.startsWith("C:\\Program Files") ||
                absPath.startsWith("C:\\Windows") ||
                FORBIDDEN_FILE_EXTENSIONS.contains(fileExtension)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean acceptInput(Path path) {
        Path absPath = path.toAbsolutePath();
        if(Files.isDirectory(absPath) || Files.notExists(path)) {
            return false;
        } else {
            return true;
        }
    }
}
