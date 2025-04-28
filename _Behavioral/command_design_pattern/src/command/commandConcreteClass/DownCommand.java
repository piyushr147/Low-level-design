package command.commandConcreteClass;

import command.Command;
import device.Device;

public class DownCommand extends Command {

    public DownCommand(Device device) {
        super(device);
    }

    @Override
    public void execute() {
        super.device.down();
    }
}
