package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

	public static IsSymptomWriter writer;

	public static ISymptomReader reader;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISymptomReader readInterface = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
		IsSymptomWriter writeInterface = new WriteSymptomDataToFile("./Project02Eclipse/result.out");

		AnalyticsCounter counter = new AnalyticsCounter(writer, reader);

		try {
			if (readInterface != null && writeInterface != null) {

				counter.readFile();

				List<String> symptomlist = counter.getSymptoms();
				System.out.println("affichage de la liste" + symptomlist);

				Map<String, Integer> countSymptomsMap = counter.countSymptoms(symptomlist);
				System.out.println(countSymptomsMap);

				//counter.writeSymptoms(countSymptomsMap);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
