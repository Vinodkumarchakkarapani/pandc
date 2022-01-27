package com.PandC.lib;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Library Class for loading Configuration from Property files
 */
public class Configuration {

	public Properties app;
	public Properties qif;

	/**
	 * Load and initialize the Configuration from Property files
	 */
	public Configuration() {
		try {
			// Initialize the Properties
			String rootPath = System.getProperty("user.dir");
			this.app = new Properties();
			this.qif = new Properties();
			Path appConfig = Paths.get(rootPath,"src/main/resources", "app.properties");
			Path qifConfig = Paths.get(rootPath,"src/main/resources", "qif.properties");

			// Get the Properties from Resource files
			this.app.load(new FileInputStream(appConfig.toFile()));
			this.qif.load(new FileInputStream(qifConfig.toFile()));
		} catch (Exception error) {
			// Make the Properties empty on error
			this.app = null;
			this.qif = null;
		}
	}

}
