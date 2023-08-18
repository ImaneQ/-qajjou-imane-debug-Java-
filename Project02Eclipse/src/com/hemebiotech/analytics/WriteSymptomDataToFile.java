package com.hemebiotech.analytics;

import java.util.Map;

public class WriteSymptomDataToFile implements IsSymptomWriter{
	
	private String filepath;
	
	public WriteSymptomDataToFile (String filepath) {
	this.filepath = filepath;
}


	public void writeSymptoms(Map<String, Integer> symptoms) {
	}
}
