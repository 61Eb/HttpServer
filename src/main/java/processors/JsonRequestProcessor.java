package processors;

import com.google.gson.Gson;
import Server.HttpRequest;
import Server.JsonObject;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class JsonRequestProcessor implements RequestProcessor {


    JsonObject Object = new JsonObject("Value1");
    String jsonResponse = new Gson().toJson(Object);

    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        httpRequest.setStatusCode(200);
        String response = "HTTP/1.1 " + httpRequest.getStatusCode() + " OK\r\nТип содержимого:  application/json\r\n\r\n" + jsonResponse;
        output.write(response.getBytes(StandardCharsets.UTF_8));

    }
}