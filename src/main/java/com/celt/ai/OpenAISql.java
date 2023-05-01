package com.celt.ai;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OpenAISql {

	public static void main(String[] args) throws IOException {
		ChatGPTSQL chat = new ChatGPTSQL();
		Properties properties = new Properties();
		ProcessDataFile inputData = new ProcessDataFile();

		try {
			properties.load(inputData.getPropertiesUrl().openStream());
		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//power chatGPT
		System.out.println("Start using Power ChatGPT!!!!!!!!!!!!!!!!!!");
		System.out.println("Response:\n" + chat.getValue());
		
	}
}
