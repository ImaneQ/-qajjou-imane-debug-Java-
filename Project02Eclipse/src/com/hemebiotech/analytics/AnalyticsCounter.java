package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnalyticsCounter {

	// méthode étape 1)
	public BufferedReader readFile() throws FileNotFoundException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("./Project02Eclipse/symptoms.txt"));
		return reader;
	}

	// méthode étape 2)

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
				Collections.sort(list);

			}

			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	// méthode étape 3)

	public Map<String, Integer> countSymptoms(List<String> listofSymptoms) {

		LinkedHashMap<String, Integer> countSymptomsMap = new LinkedHashMap<>();

		for (String s : listofSymptoms) {
			//System.out.println("-------------");
			//System.out.println("symptom " + s);

			Integer countS = countSymptomsMap.get(s);
			//System.out.println("compte " + countS);

			countSymptomsMap.put(s, (countS == null) ? 1 : countS + 1);
			System.out.println("compte après " + countSymptomsMap.get(s));

			countSymptomsMap.forEach((k, v) -> {
				System.out.println("clé : " + k + " Valeur : " + v);
			});

		}

		return countSymptomsMap;
	}

	// méthode étape 4)

	public void writeSymptoms(Map<String, Integer> countSymptomsMap) {
		// Map<String, Integer> symptoms = new HashMap<String, Integer>();

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("result.out");
			BufferedWriter writer = new BufferedWriter(fileWriter);

			for (Entry<String, Integer> entry : countSymptomsMap.entrySet()) {

				writer.write(entry.getKey() + ":" + entry.getValue());

				writer.newLine();
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static IsSymptomWriter writer;
	public static ISymptomReader reader;

	public AnalyticsCounter(IsSymptomWriter writer, ISymptomReader reader) {

		AnalyticsCounter.writer = writer;
		AnalyticsCounter.reader = reader;
	}

	public static void main(String args[]) throws Exception {

		AnalyticsCounter analytics = new AnalyticsCounter(writer, reader);
		
		analytics.readFile();
		List<String> symptomlist = analytics.getSymptoms();

		System.out.println("affichage de la liste" + symptomlist);

		Map<String, Integer> countSymptomsMap = analytics.countSymptoms(symptomlist);
		System.out.println("compte des symptomes " + countSymptomsMap);

		analytics.writeSymptoms(countSymptomsMap);

	}

}
