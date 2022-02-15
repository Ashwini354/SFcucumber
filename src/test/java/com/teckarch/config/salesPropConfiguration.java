package com.teckarch.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class salesPropConfiguration {
	public static Properties loadProperties() {
		try {
			FileInputStream input = new FileInputStream("/Users/ashwiniramamurthy/eclipse-workspace/salesforceproject/src/main/resources/SalesApplication.proerties");
		

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
