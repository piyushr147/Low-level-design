import adapter.XmlToJson;
import adapter.YmlToJson;
import target.ServerXML;
import target.ServerYML;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        XmlToJson xmlToJsonAdapter = new XmlToJson(new ServerXML());
        YmlToJson ymlToJsonAdapter = new YmlToJson(new ServerYML());

        //client code
        String data = xmlToJsonAdapter.convertData("");
        String data2 = ymlToJsonAdapter.convertData("");
        System.out.println(data);
        System.out.println(data2);
    }
}