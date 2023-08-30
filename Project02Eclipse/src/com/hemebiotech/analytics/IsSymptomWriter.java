package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public interface IsSymptomWriter {

	IsSymptomWriter writeInterface = new WriteSymptomDataToFile("./Project02Eclipse/src/result.out");

	void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
