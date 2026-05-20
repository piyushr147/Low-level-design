import cloudStorageProvider.app.CloudApp;
import cloudStorageProvider.concreteClient.AwsClient;
import cloudStorageProvider.concreteClient.GcpClient;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        CloudApp AWSClient = new CloudApp(new AwsClient());
        CloudApp GCPClient = new CloudApp(new GcpClient());

        AWSClient.sendData("/bucket/202","hello world");
        GCPClient.sendData("/bucket/100","entering into cloud");
    }
}