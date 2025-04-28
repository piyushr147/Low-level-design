package command;

import device.Device;

public abstract class Command {

    protected Device device;

    public Command(Device device) {
        this.device = device;
    }

    public abstract void execute();
}
