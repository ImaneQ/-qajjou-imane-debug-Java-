package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * La classe Main qui sert à lancer les étapes successives de l'application.
 */

public class Main {

	public static IsSymptomWriter writer;

	public static ISymptomReader reader;

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
		ISymptomReader readInterface = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
		IsSymptomWriter writeInterface = new WriteSymptomDataToFile("./Project02Eclipse/result.out");

		AnalyticsCounter counter = new AnalyticsCounter(writer, reader);
		/*ISymptomReader reader = counter;
		ISymptomReader read = AnalyticsCounter.reader;*/

		try {
			if (readInterface != null && writeInterface != null) {

				counter.readFile();

				List<String> symptomlist = counter.getSymptoms();
				System.out.println("affichage de la liste" + symptomlist);

				Map<String, Integer> countSymptomsMap = counter.countSymptoms(symptomlist);
				System.out.println(countSymptomsMap);

				Map<String, Integer> sortedSymptons = counter.sortSymptoms(countSymptomsMap);
				System.out.println("tri des symptomes " + sortedSymptons);

				counter.writeSymptoms(sortedSymptons);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
