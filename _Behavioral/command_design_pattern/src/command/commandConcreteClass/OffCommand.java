package command.commandConcreteClass;

import command.Command;
import device.Device;

public class OffCommand extends Command {

    public OffCommand(Device device) {
        super(device);
    }

    @Override
    public void execute() {
        super.device.down();
    }
}
