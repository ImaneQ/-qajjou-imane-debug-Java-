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

public class AnalyticsCounter implements ISymptomReader, IsSymptomWriter {

	/**
	 * @return Une méthode readFile() qui renvoie une variable de type
	 *         BufferedReader initialisée reader.
	 */

	public BufferedReader readFile() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader("./Project02Eclipse/symptoms.txt"));
		return reader;
	}

	/**
	 * @exception IOException levée lors de l'accès aux informations à l'aide d'un
	 *                        fichier.
	 * @return Une méthode getSymptoms() qui permet de renvoyer une liste de chaînes
	 *         de caractères.
	 */

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

	/**
	 * @param list Liste des symptômes retournés dans la méthode getSymptoms().
	 * @see getSymptoms().
	 * @return Une méthode countSymptoms() qui permet de renvoyer une structure de
	 *         données dont chaque entrée est constituée d’une clé de type String et
	 *         d’une Valeur de type Integer.
	 */

	public Map<String, Integer> countSymptoms(List<String> list) {

		Map<String, Integer> countSymptomsMap = new HashMap<String, Integer>();

		for (String s : list) {

			Integer countS = countSymptomsMap.get(s);

			countSymptomsMap.put(s, (countS == null) ? 1 : countS + 1);

		}

		return countSymptomsMap;
	}

	/**
	 * @param countSymptomsMap Structure de données retournée dans la méthode
	 *                         countSymptoms().
	 * @see countSymptoms().
	 * @return Une méthode sortSymptoms() qui permet de trier les symptômes par
	 *         ordre alphabétique et retourne une collection de données triées.
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> countSymptomsMap) {

		Map<String, Integer> sortedTreeMap = new TreeMap<>(countSymptomsMap);

		System.out.println("test TreeMap " + sortedTreeMap);

		return sortedTreeMap;

	}

	/**
	 * @param sortedTreeMap Structure de données retournée dans la méthode
	 *                      sortSymptoms().
	 * @see sortSymptoms().
	 */

	public void writeSymptoms(Map<String, Integer> sortedTreeMap) {

		// IsSymptomWriter writer = FileWriter("result.out");
		// IsSymptomWriter writeInterface;
		FileWriter fileWriter;
		IsSymptomWriter writeInterface = new WriteSymptomDataToFile("./Project02Eclipse/result.out");

		try {

			fileWriter = new FileWriter("./Project02Eclipse/result.out");
			BufferedWriter writer = new BufferedWriter(fileWriter);

			for (Entry<String, Integer> entry : sortedTreeMap.entrySet()) {

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

	/**
	 * Le constructeur de la classe AnalyticsCounter qui permet de construire un
	 * objet de la classe.
	 * 
	 * @param objet reader de type ISymptomReader.
	 * @param objet writer de type IsSymptomWriter.
	 */

	public AnalyticsCounter(IsSymptomWriter writer, ISymptomReader reader) {

		this.writer = writer;
		this.reader = reader;
	}

	/**
	 * La méthode main() est la première fonction exécutée lors du lancement du
	 * programme.
	 */
	/*
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

	}*/

}
