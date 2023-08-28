package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AnalyticsCounter implements ISymptomReader, IsSymptomWriter {

	public BufferedReader readFile() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader("./Project02Eclipse/symptoms.txt"));
		return reader;
	}

	public List<String> getSymptoms() throws IOException {
		BufferedReader reader = readFile();

		ArrayList<String> list = new ArrayList<String>();

		if (reader != null) {

			try {
				String line = reader.readLine();

				while (line != null) {

					list.add(line);
					line = reader.readLine();

				}
				reader.close();

			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Map<String, Integer> countSymptoms(List<String> list) {

		Map<String, Integer> countSymptomsMap = new HashMap<String, Integer>();

		for (String s : list) {

			Integer countS = countSymptomsMap.get(s);

			countSymptomsMap.put(s, (countS == null) ? 1 : countS + 1);

		}

		return countSymptomsMap;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> countSymptomsMap) {

		/*
		 * LinkedHashMap<String, Integer> sortSymptomsMap =
		 * countSymptomsMap.entrySet().stream()
		 * .sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::
		 * getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
		 * LinkedHashMap::new));
		 */

		// TEST avec TreeMap
		Map<String, Integer> sortedTreeMap = new TreeMap<>(countSymptomsMap);

		// System.out.println("test LinkedHashMap " + sortSymptomsMap);
		System.out.println("test TreeMap " + sortedTreeMap);

		return sortedTreeMap;

	}

	public void writeSymptoms(Map<String, Integer> sortSymptomsMap) {

		// IsSymptomWriter writer = FileWriter("result.out");
		// IsSymptomWriter writeInterface;
		FileWriter fileWriter;
		IsSymptomWriter writeInterface = new WriteSymptomDataToFile("./Project02Eclipse/result.out");

		try {

			fileWriter = new FileWriter("./Project02Eclipse/result.out");
			BufferedWriter writer = new BufferedWriter(fileWriter);

			for (Entry<String, Integer> entry : sortSymptomsMap.entrySet()) {

				writer.write(entry.getKey() + ":" + entry.getValue());

				writer.newLine();
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static IsSymptomWriter writer;
	public static ISymptomReader reader;

	public AnalyticsCounter(IsSymptomWriter writer, ISymptomReader reader) {

		this.writer = writer;
		this.reader = reader;
	}

	public static void main(String args[]) throws Exception {

		AnalyticsCounter analytics = new AnalyticsCounter(writer, reader);

		analytics.readFile();
		List<String> symptomlist = analytics.getSymptoms();

		System.out.println("affichage de la liste" + symptomlist);

		Map<String, Integer> countSymptomsMap = analytics.countSymptoms(symptomlist);
		System.out.println("compte des symptomes " + countSymptomsMap);

		Map<String, Integer> sortedSymptons = analytics.sortSymptoms(countSymptomsMap);

		System.out.println("tri des symptomes " + sortedSymptons);

		analytics.writeSymptoms(sortedSymptons);

	}

}
