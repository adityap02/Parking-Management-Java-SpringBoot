package com.epam.engx.cleancode.naming.task5.predicates;


import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtensionPredicate implements Predicate<String> {

    private String[] extensions;

    public FileExtensionPredicate(String[] extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean test(String fileName) {
		List<String> fileExtensions = Arrays.asList(extensions);
		Stream<String> data = fileExtensions.stream().filter(e -> fileName.toLowerCase().endsWith(e));
    	return(isValidFileExtension(data));
		/*
		 * for (String extension : extensions) { if
		 * (fileName.toLowerCase().endsWith(extension)) { return true; } } return false;
		 */
    	boolean isValidFileExtension(Stream<String> data) {
    		if(data.count(>0))
    			return true;
    		return false;
    					
    	}
    }
}
