package com.epam.engx.cleancode.naming.task5.predicates;


import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtPred implements Predicate<String> {

    private String[] extns;

    public FileExtPred(String[] extns) {
        this.extns = extns;
    }

    @Override
    public boolean test(String fileName) {
        for (String extension : extns) {
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
