package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @param sortedTreeMap Structure de données retournée dans la méthode
	 *                      sortSymptoms().
	 * @see sortSymptoms() dans la classe ReadSymptomDataFromFile.
	 */

	@Override
	public void writeSymptoms(Map<String, Integer> symptomsToWrite) throws IOException {

		try {
			File createNewFile = new File(filepath);
			if (createNewFile.createNewFile()) {
				System.out.println("File created: " + createNewFile.getName());
			} else {
				System.out.println("File already exists.");
			}
			FileWriter fr = null;

			fr = new FileWriter(createNewFile);

			for (Entry<String, Integer> entry : symptomsToWrite.entrySet()) {

				fr.write(entry.getKey() + ":" + entry.getValue());

				fr.write(System.lineSeparator());
			}

			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
