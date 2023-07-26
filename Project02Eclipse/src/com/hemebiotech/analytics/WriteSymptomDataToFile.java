package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataToFile implements IsSymptomWriter{
	
	private String filepath;
	
	public WriteSymptomDataToFile (String filepath) {
	this.filepath = filepath;
}


	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		Map<String, Integer> myResult = new HashMap<String, Integer>();
		
		try {
			
			/* ajouter des éléments à notre dictionnaire on 
			utilise myMap.put(clé, valeur) par pair clé-valeur*/
			
			FileWriter fileWriter = new FileWriter("result.out");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			// écrire symptômes + quantité
			
			writer.write(fileWriter);
			writer.newLine();
			myResult.put(filepath, null);
			writer.close();
					
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
