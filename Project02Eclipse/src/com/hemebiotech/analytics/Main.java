package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * La classe Main sert à lancer les étapes successives de l'application.
 */

public class Main {

	/**
	 * La méthode main() est la première fonction exécutée lors du lancement du
	 * programme.
	 * 
	 * @param args Les arguments de la ligne de commande.
	 * @exception FileNotFoundException concerne un fichier non trouvé.
	 * 
	 * @exception IOException           levée lors de l'accès aux informations à
	 *                                  l'aide d'un fichier.
	 */

	public static void main(String[] args) {

		ISymptomReader filepathReadSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter filepathWriteSymptoms = new WriteSymptomDataToFile("results.out");

		AnalyticsCounter counter = new AnalyticsCounter(filepathWriteSymptoms, filepathReadSymptoms);

		try {

			List<String> symptomList = counter.getSymptoms();

			Map<String, Integer> countSymptomsMap = counter.countSymptoms(symptomList);

			Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countSymptomsMap);

			counter.writeSymptoms(sortedSymptoms);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
