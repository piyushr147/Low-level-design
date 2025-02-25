package adapter;

import adaptee.DataConverter;
import target.ServerXML;

public class XmlToJson implements DataConverter {

    ServerXML serverXML;

    public XmlToJson(ServerXML server){
        this.serverXML = server;
    }

    @Override
    public String convertData(String data) {
        System.out.println("converting xml to json...");
        return serverXML.getData();
    }
}
