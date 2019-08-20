package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

	public static Properties readConfigProperties(String configFileName) throws Exception {

		configFileName = configFileName.trim();

		Properties property = new Properties();

		InputStream inStream = new FileInputStream(configFileName);

		property.load(inStream);

		return property;

	}

}
