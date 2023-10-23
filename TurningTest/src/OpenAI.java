import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;


public class OpenAI {
    public static String chatGPT(String prompt) throws IOException{
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "API KEY";
        String model = "gpt-3.5-turbo";


            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization","Bearer" + apiKey);
            connection.setRequestProperty("Content-Type","application/json");

            // The request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Response from ChatGPT
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuffer response = new StringBuffer();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();;
        System.out.println(response.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.toString());
        return node.get("choices").get(0).get("message").get("content").asText();


    }


        }

