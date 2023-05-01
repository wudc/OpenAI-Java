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

public class ChatGPTSQL {
	
	private OpenAiService service;
	private List<String> numbers;
	
	public ChatGPTSQL() throws IOException {
		ProcessDataFile inputData = new ProcessDataFile();
		Properties properties = new Properties();
		properties.load(inputData.getPropertiesUrl().openStream());
		String token = properties.getProperty("API_KEY");
		
        service = new OpenAiService(token);
	}
	
	public void setData(List<String> data) { this.numbers = data; }
	
	private String createInputMessage() {
		StringBuffer messages = new StringBuffer("Create a SQL request to find all Products made in United States:");
		return messages.toString();
	}
	
	public String getValue() {
		String message = createInputMessage();
		System.out.println("Prompt:\n" + message);
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
	}
}
