package processors;

import Server.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HelloWorldRequestProcessor implements RequestProcessor {

    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        System.out.println("Обработка HelloWorldRequestProcessor...");
        String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body><h1>Hello World!</h1></body></html>";
        output.write(response.getBytes(StandardCharsets.UTF_8));
        System.out.println("HelloWorldRequestProcessor успешно обработан.");
    }
}