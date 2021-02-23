package com.epam.engx.cleancode.naming.task5.predicates;


import java.util.*;


import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtensionPredicate implements Predicate<String> {

    private String[] extensions;

    public FileExtensionPredicate(String[] extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean test(String fileName) {
    	
		List<String> fileExtensions = Arrays.asList(extensions);
		
    	boolean anyNonEmpty = fileExtensions.stream().anyMatch(a -> fileName.endsWith(a));
		return anyNonEmpty;

    }
}
