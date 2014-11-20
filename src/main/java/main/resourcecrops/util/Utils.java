package main.resourcecrops.util;

import main.resourcecrops.ResourcefulCrops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

	public static void writeOreDictLog(String info, String fileName) {
		try {
			File log = new File(ResourcefulCrops.mcPath + "/" + fileName);
			if (!log.exists()) {
				if (log.createNewFile()) {
					ResourcefulCrops.logger.info("Creating " + fileName + " at " + ResourcefulCrops.mcPath);
				}
			}
			FileWriter fileWriter = new FileWriter(log.getAbsoluteFile(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(info);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			ResourcefulCrops.logger.error(fileName + " was not found at " + ResourcefulCrops.mcPath);
		}
	}
}
