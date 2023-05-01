package com.celt.ai.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.celt.ai.ProcessDataFile;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

public class OpenAIGPTApiExample {
    public static void main(String... args) throws IOException {
        //String token = System.getenv("OPENAI_TOKEN");
        
		ProcessDataFile inputData = new ProcessDataFile();
		Properties properties = new Properties();
		properties.load(inputData.getPropertiesUrl().openStream());
		String token = properties.getProperty("API_KEY");
		
        OpenAiService service = new OpenAiService(token);
        
        String testMessage ="Look at this list of integer sets and predict the next set. {1 2 5 0}, {3 4 9 1}, {0 2 6 0}, {0 0 0 0}, {3 2 9 0}";
        final List<ChatMessage> messages = new ArrayList<>();
        //final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.USER.value(), "Hello ChatGPT, Greetings from planet Mars.");
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.USER.value(), testMessage);
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
        System.out.println(choices.get(0).getMessage().getContent());

        
        service.shutdownExecutor();
    }
}
