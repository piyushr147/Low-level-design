import command.commandConcreteClass.DownCommand;
import command.commandConcreteClass.OffCommand;
import command.commandConcreteClass.OnCommand;
import command.commandConcreteClass.UpCommand;
import device.Device;
import device.deviceConcreteClass.AirConditioner;
import invoker.Invoker;

import java.util.Collection;
import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Device device = new AirConditioner();
        Invoker invoker = new Invoker(new OnCommand(device),new OffCommand(device), new UpCommand(device), new DownCommand(device));
        invoker.clickDown();
        Collection collection = new HashSet();
    }
}