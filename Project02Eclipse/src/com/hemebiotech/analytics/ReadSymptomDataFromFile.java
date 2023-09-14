package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * @param filepath chemin d'accès au fichier sous forme de chaîne de caractères.
	 * 
	 */

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @return Une méthode readFile() qui renvoie un BufferedReader.
	 */

	public BufferedReader readFile() throws FileNotFoundException {
		return new BufferedReader(new FileReader(filepath));
	}

	/**
	 * @exception IOException exception qui pourrait survenir lors de la lecture du
	 *                        fichier.
	 * @return La méthode getSymptoms() permet de renvoyer une liste de chaînes de
	 *         caractères.
	 */

	@Override
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
	 * @return La méthode countSymptoms() permet de renvoyer une structure de
	 *         données dont chaque entrée est constituée d’une Clé de type String et
	 *         d’une Valeur de type Integer.
	 */

	@Override
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
	 * @return La méthode sortSymptoms() permet de trier les symptômes par ordre
	 *         alphabétique et retourne une collection de données triée.
	 */

	@Override
	public Map<String, Integer> sortSymptoms(Map<String, Integer> countSymptomsMap) {
		Map<String, Integer> sortedTreeMap = new TreeMap<>(countSymptomsMap);

		return sortedTreeMap;

	}

}
