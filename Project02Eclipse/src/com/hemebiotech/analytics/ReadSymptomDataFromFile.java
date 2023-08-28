package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public BufferedReader readFile() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader("./Project02Eclipse/src/symptoms.txt"));
		return reader;
	}

	@Override
	public List<String> getSymptoms() {
		return null;
	}

	@Override
	public Map<String, Integer> countSymptoms(List<String> list) {
		return null;
	}

}
