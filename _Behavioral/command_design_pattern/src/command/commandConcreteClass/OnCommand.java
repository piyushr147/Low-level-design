package command.commandConcreteClass;

import command.Command;
import device.Device;

public class OnCommand extends Command {
    public OnCommand(Device device) {
        super(device);
    }

    @Override
    public void execute() {
        super.device.down();
    }
}
