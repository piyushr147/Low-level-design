package computer;

import enums.RequestType;

import java.util.HashMap;

public class HttpRequest {
    private String url;
    private String body;
    private HashMap<String,String> headers;
    private HashMap<String,String> parameters;
    private RequestType requestType;

    private HttpRequest(Builder builder) {
        url = builder.url;
        body = builder.body;
        headers = builder.headers;
        parameters = builder.parameters;
        requestType = builder.requestType;
    }

    public String getUrl() {
        return url;
    }

    public String getBody() {
        return body;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public static class Builder{
        private String url;
        private String body;
        private HashMap<String,String> headers;
        private HashMap<String,String> parameters;
        private RequestType requestType;

        public HttpRequest build(){
            return new HttpRequest(this);
        }

        public Builder setUrl(String url){
            this.url = url;
            return this;
        }

        public Builder setBody(String body){
            this.body = body;
            return this;
        }

        public Builder setHeaders(HashMap<String, String> headers){
            this.headers = headers;
            return this;
        }

        public Builder setParameters(HashMap<String, String> parameters){
            this.parameters = parameters;
            return this;
        }

        public Builder setRequestType(RequestType requestType){
            this.requestType = requestType;
            return this;
        }
    }
}
