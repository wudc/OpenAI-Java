package com.celt.ai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

public class ChatGPTExample {
	
	private OpenAiService service;
	private List<String> numbers;
	
	public ChatGPTExample() throws IOException {
		ProcessDataFile inputData = new ProcessDataFile();
		Properties properties = new Properties();
		properties.load(inputData.getPropertiesUrl().openStream());
		String token = properties.getProperty("API_KEY");
		
        service = new OpenAiService(token);
	}
	
	public void setData(List<String> data) { this.numbers = data; }
	
	private String createInputMessage() {
		//StringBuffer messages = new StringBuffer("Train with the given list of integer sets by date and do your very best to predict the next integer set by date. ");
		StringBuffer messages = new StringBuffer("Analyze and train with the following set of numbers with date in mm/dd/yyyy format. Do your very best to predict the next numbers set for 04/19/2023 date. ");
		
		
		numbers.forEach((number)-> {
			messages.append(number + " ");
			});
		
		return messages.toString();
	}
	
	public String getValue() {
		String message = createInputMessage();
		System.out.println("ChatGPT message is: " + message);
        final List<ChatMessage> messages = new ArrayList<>();
        
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.USER.value(), message);
        messages.add(systemMessage);
        
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        List<ChatCompletionChoice> choices = service.createChatCompletion(chatCompletionRequest).getChoices();

        return choices.get(0).getMessage().getContent();
        //return message;
	}
}
