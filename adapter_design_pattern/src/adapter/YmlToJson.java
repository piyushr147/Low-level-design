package adapter;

import adaptee.DataConverter;
import target.ServerYML;

public class YmlToJson implements DataConverter {

    ServerYML serverYML;

    public YmlToJson(ServerYML server){
        this.serverYML = server;
    }

    @Override
    public String convertData(String data) {
        System.out.println("converting yml to json...");
        return serverYML.recieveData();
    }
}
