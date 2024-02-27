package processors;

import Server.HttpRequest;
import Server.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
/**
 * В приведенном коде добавлены логгеры для информации о начале
 * и успешном завершении обработки запроса,
 * а также для ошибок при обработке запроса.
 */
public class OperationAddRequestProcessor implements RequestProcessor {

    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        try {
            int a = Integer.parseInt(httpRequest.getParameter("a"));
            int b = Integer.parseInt(httpRequest.getParameter("b"));
            int result = a + b;

            String newResponse = "HTTP/1.1 200 OK\r\nТип содержимого: text/html\r\n\r\n<html><body><h1>" + a + " + " + b + " = " + result + "</h1></body></html>";
            httpRequest.setStatusCode(200);
            String response = "HTTP/1.1 " + httpRequest.getStatusCode() + " OK\r\nТип содержимого: text/html\r\n\r\n<html><body><h1>" + a + " + " + b + " = " + result + "</h1></body></html>";
            output.write(response.getBytes(StandardCharsets.UTF_8));

        } catch (NumberFormatException e) {
            String errorResponse = "HTTP/1.1 400 Неверный запрос\r\nТип содержимого: text/plain\r\n\r\nНеверные параметры";
            httpRequest.setStatusCode(400);
            output.write(errorResponse.getBytes(StandardCharsets.UTF_8));
        }
    }
}