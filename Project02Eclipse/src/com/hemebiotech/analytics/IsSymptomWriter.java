package com.hemebiotech.analytics;

import java.util.Map;

public interface IsSymptomWriter {

	IsSymptomWriter writeInterface = new WriteSymptomDataToFile("./Project02Eclipse/src/result.out");

	void writeSymptoms(Map<String, Integer> symptoms);
}
