package com.hemebiotech.analytics;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
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
	public String filepath;

	/**
	 * Le constructeur de la classe AnalyticsCounter qui permet de construire un
	 * objet de la classe.
	 * 
	 * @param objet reader de type ISymptomReader.
	 * @param objet writer de type IsSymptomWriter.
	 */

	public AnalyticsCounter(ISymptomWriter writerParam, ISymptomReader readerParam) {

		this.writer = writerParam;
		this.reader = readerParam;
	}

	public BufferedReader readFile() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		return reader;
	}

	public List<String> getSymptoms() throws IOException {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> list) {
		return reader.countSymptoms(list);
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> countSymptomsMap) {
		return reader.sortSymptoms(countSymptomsMap);
	}

	public void writeSymptoms(Map<String, Integer> sortedTreeMap) throws IOException {
		writer.writeSymptoms(sortedTreeMap);
	}

}
