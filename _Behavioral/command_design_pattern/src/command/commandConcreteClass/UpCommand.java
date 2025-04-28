package command.commandConcreteClass;

import command.Command;
import device.Device;

public class UpCommand extends Command {
    public UpCommand(Device device) {
        super(device);
    }

    @Override
    public void execute() {
        super.device.down();
    }
}
