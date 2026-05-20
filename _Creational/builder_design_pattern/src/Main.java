import computer.HttpRequest;
import enums.RequestType;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,String> params = new HashMap<>();
        params.put("id","1");

        HashMap<String,String> headers = new HashMap<>();
        params.put("json","true");

        HttpRequest request =
                new HttpRequest.Builder()
                        .setUrl("hello.com")
                        .setBody("{data: {name:piyush}}")
                        .setHeaders(headers)
                        .setRequestType(RequestType.GET)
                        .setParameters(params)
                        .build();
    }
}