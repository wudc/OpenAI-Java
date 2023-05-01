package com.celt.ai;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OpenAIFirst {

	public static void main(String[] args) throws IOException {
		ChatGPTExample chat = new ChatGPTExample();
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
		
		List<String> years = new ArrayList<>();
		years.add("2023");
		//years.add("2022");
		//years.add("2020");

		//mega chatGPT
//		System.out.println("Start using Mega ChatGPT!!!!!!!!!!!!!!!!!!");
//		List<String> dataList = data.getPreviousDataWithDate(inputData.getMegaFileUrl(), years);
//		//ChatGPTExample chat = new ChatGPTExample();
//		chat.setData(dataList);
//		System.out.println("Prediction: " + chat.getValue());
		
		//power chatGPT
		System.out.println("Start using Power ChatGPT!!!!!!!!!!!!!!!!!!");
		List<String> dataList = data.getPreviousDataWithDate(inputData.getPowerFileUrl(), years);
		//chat = new ChatGPTExample();
		chat.setData(dataList);
		System.out.println("Prediction: " + chat.getValue());
		
	}
	
	public static void getPrediction(List<String> dataList, List<String> years, ChatGPTExample chat) throws IOException {
		chat.setData(dataList);
		System.out.println("Prediction: " + chat.getValue());
	}

}
