package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * @exception IOException exception qui pourrait survenir lors de la lecture du
 *                        fichier.
 */

public interface ISymptomWriter {

	void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
