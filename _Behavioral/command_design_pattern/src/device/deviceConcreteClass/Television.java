package device.deviceConcreteClass;

import device.Device;

public class Television implements Device {
    @Override
    public void on() {
        System.out.println("Television on");
    }

    @Override
    public void off() {
        System.out.println("Television off");
    }

    @Override
    public void up() {
        System.out.println("Television channel up");
    }

    @Override
    public void down() {
        System.out.println("Television channel down");
    }
}
