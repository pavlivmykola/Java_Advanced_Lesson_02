package ua.lviv.lgs;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CustomLoggerFile {
	private static Logger LOG = Logger.getLogger(CustomLoggerFile.class);
	
	public static void logError(String message) {
		DOMConfigurator.configure("loggerConfig.xml");
		LOG.error(message);
	}
	
	
}
