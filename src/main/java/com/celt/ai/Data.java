package com.celt.ai;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class Data {
	public List<String> getPreviousData(URL url, List<String> years) throws IOException {

        List<String> dataList = new ArrayList<>();

        File file = new File(url.getFile());
        try (LineIterator iterator = FileUtils.lineIterator(file, "UTF-8")) {
            while (iterator.hasNext()) {
                String line = iterator.nextLine();
                
                if ( isValidata(line) && withYear(years, line) ) {
	                String[] eachLine = line.split(";");
	                
	                String firstFive = eachLine[1].trim().replace(",", " ");
	                String lastStr = eachLine[2];
	                String[] lastList = lastStr.split(":");
	                String last = lastList[1].trim();
	                String dataSet = "{" + firstFive + " " + last + "}";
	                //System.out.println(dataSet);
	                dataList.add(dataSet);
                }
            }
        }
        
        return dataList;
	}
	
	public List<String> getPreviousDataWithDate(URL url, List<String> years) throws IOException {
		String date = null;
		String numbers = null;
        List<String> dataList = new ArrayList<>();

        File file = new File(url.getFile());
        try (LineIterator iterator = FileUtils.lineIterator(file, "UTF-8")) {
            while (iterator.hasNext()) {
                String line = iterator.nextLine();
                
                if ( isValidata(line) && withYear(years, line) ) {
	                String[] eachLine = line.split("\\s");
	                date = eachLine[0];
	                numbers = 
		                eachLine[1] + " " + 
		                eachLine[2] + " " + 
		                eachLine[3] + " " + 
		                eachLine[4] + " " + 
		                eachLine[5] + " " + 
		                eachLine[6];
	                
	                String dataSet = "{" + date + " " + numbers + "}";
	                System.out.println(dataSet);
	                dataList.add(dataSet);
                }
            }
        }
        
        return dataList;
	}
	
	private boolean withYear(List<String> years, String line) {
		for (String str : years) {
			if ( line.contains(str) ) {
				return true;
			}			
		}

		return false;
	}
	private boolean isValidata(String line) {
		boolean found = false;
		char[] chars = line.toCharArray();

		for (char c : chars) {
			if (Character.isDigit(c)) {
				found = true;
				break;
			}
		}
		return found;
	}
}
