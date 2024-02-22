package processors;

import Server.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OperationAddRequestProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {

        try {
            int a = Integer.parseInt(httpRequest.getParameter("a"));
            int b = Integer.parseInt(httpRequest.getParameter("b"));
            int result = a + b;
            String response = "HTTP/1.1 200 OK\r\nТип содержимого: text/html\r\n\r\n<html><body><h1>" + a + " + " + b + " = " + result + "</h1></body></html>";
            output.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (NumberFormatException e) {
            String errorResponse = "HTTP/1.1 400 Неверный запрос\r\nТип содержимого: text/plain\r\n\r\nнедопустимые параметры";
            output.write(errorResponse.getBytes(StandardCharsets.UTF_8));
        }
    }
}
