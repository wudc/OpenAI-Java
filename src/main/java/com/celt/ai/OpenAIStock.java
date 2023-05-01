package com.celt.ai;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OpenAIStock {

	public static void main(String[] args) throws IOException {
		ChatGPTStockAnalysis chat = new ChatGPTStockAnalysis();
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
		System.out.println("Prediction: " + chat.getValue());
		
	}
	
	public static void getPrediction(List<String> dataList, List<String> years, ChatGPTExample chat) throws IOException {
		chat.setData(dataList);
		System.out.println("Prediction: " + chat.getValue());
	}

}
