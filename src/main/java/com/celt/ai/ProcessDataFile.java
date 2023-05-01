package com.celt.ai;

import java.net.URL;

public class ProcessDataFile {
	private URL propertiesUrl;

	public ProcessDataFile() {
		propertiesUrl = ClassLoader.getSystemResource("test.properties");
	}

	public URL getPropertiesUrl() {
		return propertiesUrl;
	}
	
}
