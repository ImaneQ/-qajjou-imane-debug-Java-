package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */

public interface ISymptomReader {

	BufferedReader readFile() throws FileNotFoundException;

	List<String> getSymptoms() throws IOException;

	Map<String, Integer> countSymptoms(List<String> list);

	Map<String, Integer> sortSymptoms(Map<String, Integer> countSymptomsMap);

}
