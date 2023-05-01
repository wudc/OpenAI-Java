package com.celt.ai;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OpenAIUserStory {

	public static void main(String[] args) throws IOException {
		ChatGPTUserStory chat = new ChatGPTUserStory();
		Properties properties = new Properties();
		ProcessDataFile inputData = new ProcessDataFile();

		try {
			properties.load(inputData.getPropertiesUrl().openStream());
		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// getData
		Data data = new Data();
		
		//power chatGPT
		System.out.println("Start using Power ChatGPT!!!!!!!!!!!!!!!!!!");
		System.out.println("Response:\n" + chat.getValue());
		
	}
}
