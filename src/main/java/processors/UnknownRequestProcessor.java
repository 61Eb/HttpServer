package processors;


import Server.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
/**
 * В этом коде добавлены логгеры для информации о начале
 * и успешном завершении обработки запроса с предупреждением (warn)
 */
public class UnknownRequestProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {

        String response = "HTTP/1.1 200 OK\r\nТип содержимого: text/html;charset=utf-8\r\n\r\n<html><body><h1>Получен неизвестный запрос</h1></body></html>";
        httpRequest.setStatusCode(404);
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}