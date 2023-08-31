package com.hemebiotech.analytics;

import java.io.BufferedWriter;
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
	 * @see sortSymptoms().
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {

		try {

			FileWriter fileWriter = new FileWriter(filepath);
			BufferedWriter writer = new BufferedWriter(fileWriter);

			for (Entry<String, Integer> entry : symptoms.entrySet()) {

				writer.write(entry.getKey() + ":" + entry.getValue());

				writer.newLine();
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
