package com.hemebiotech.analytics;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * La classe AnalyticsCounter refactorée.
 * 
 * @author Imane Qajjou
 */

public class AnalyticsCounter implements ISymptomReader, ISymptomWriter {
	public static ISymptomWriter writer;
	public static ISymptomReader reader;

	public BufferedReader readFile() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader("./Project02Eclipse/symptoms.txt"));
		return reader;
	}

	public List<String> getSymptoms() throws IOException {
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");

		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> list) {
		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile();
		return read.countSymptoms(list);
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> countSymptomsMap) {
		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile();
		return read.sortSymptoms(countSymptomsMap);
	}

	public void writeSymptoms(Map<String, Integer> sortedTreeMap) {

		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile("./Project02Eclipse/result.out");
	}

	/**
	 * Le constructeur de la classe AnalyticsCounter qui permet de construire un
	 * objet de la classe.
	 * 
	 * @param objet reader de type ISymptomReader.
	 * @param objet writer de type IsSymptomWriter.
	 */

	public AnalyticsCounter(ISymptomWriter writer, ISymptomReader reader) {

		this.writer = writer;
		this.reader = reader;
	}

}
