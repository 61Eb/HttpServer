package Server;

import processors.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


public class Dispatcher {

    private Map<String, RequestProcessor> router;
    private RequestProcessor unknownRequestProcessor;

    public Dispatcher() {
        this.router = new HashMap<>();
        this.router.put("/json", new JsonRequestProcessor());
        this.router.put("GET /add", new OperationAddRequestProcessor());
        this.router.put("/hello_world", new HelloWorldRequestProcessor());
        this.unknownRequestProcessor = new UnknownRequestProcessor();
    }

    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        if (!router.containsKey(httpRequest.getUri())) {
            unknownRequestProcessor.execute(httpRequest, output);
            return;
        }
        RequestProcessor requestProcessor = router.get(httpRequest.getUri());
        requestProcessor.execute(httpRequest, output);
    }


}
