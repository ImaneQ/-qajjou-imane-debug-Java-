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

		ISymptomReader filepathReadSymptoms = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
		ISymptomWriter filepathWriteSymptoms = new WriteSymptomDataToFile("./Project02Eclipse/results.out");

		AnalyticsCounter counter = new AnalyticsCounter(filepathWriteSymptoms, filepathReadSymptoms);

		try {

			List<String> symptomList = counter.getSymptoms();
			System.out.println("Affichage de la liste : " + symptomList);

			Map<String, Integer> countSymptomsMap = counter.countSymptoms(symptomList);
			System.out.println("Compte du nombre de symptômes : " + countSymptomsMap);

			Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countSymptomsMap);
			System.out.println("Tri des symptômes par ordre alphabétique : " + sortedSymptoms);

			counter.writeSymptoms(sortedSymptoms);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
