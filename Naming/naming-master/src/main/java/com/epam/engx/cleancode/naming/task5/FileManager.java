package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.predicates.FileExtPred;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class FileManager {

    private static final String[] TYPES = {"jpg", "png"};
    private static final String[] TYPES2 = {"pdf", "doc"};

    private String bp = PropertyUtil.loadProperty("basePath");

    public File retrieveFile(String fileName) {
        validateFileType(fileName);
        final String dirPath = bp + File.separator;
        return Paths.get(dirPath, fileName).toFile();
    }

    public List<String> listAllImages() {
        return files(bp, TYPES);
    }

    public List<String> listAllDocumentFiles() {
        return files(bp, TYPES2);
    }

    private void validateFileType(String fileName) {
        if (isInvalidFileType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidFileType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtPred imageExtensionsPredicate = new FileExtPred(TYPES);
        return !imageExtensionsPredicate.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtPred documentExtensionsPredicate = new FileExtPred(TYPES2);
        return !documentExtensionsPredicate.test(fileName);
    }

    private List<String> files(String directoryPath, String[] allowedExtensions) {
        final FileExtPred pred = new FileExtPred(allowedExtensions);
        return Arrays.asList(directory(directoryPath).list(getFilenameFilterByPredicate(pred)));
    }

    private FilenameFilter getFilenameFilterByPredicate(final FileExtPred pred) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String str) {
                return pred.test(str);
            }
        };
    }

    private File directory(String directoryPath) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directoryInstance) {
        if (isNotDirectory(directoryInstance)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directoryInstance.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File dir) {
        return !dir.isDirectory();
    }

}