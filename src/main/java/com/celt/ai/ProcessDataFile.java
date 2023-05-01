package com.celt.ai;

import java.net.URL;

public class ProcessDataFile {
	private URL propertiesUrl;
	private URL megaFileUrl;
	private URL powerFileUrl;
	
	public URL getMegaFileUrl() {
		return megaFileUrl;
	}

	public URL getPowerFileUrl() {
		return powerFileUrl;
	}

	public ProcessDataFile() {
		propertiesUrl = ClassLoader.getSystemResource("test.properties");
		megaFileUrl = ClassLoader.getSystemResource("MegaMillions.txt");
		powerFileUrl = ClassLoader.getSystemResource("Powerball.txt");
	}

	public URL getPropertiesUrl() {
		return propertiesUrl;
	}
	
}
