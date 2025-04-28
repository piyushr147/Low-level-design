package device.deviceConcreteClass;

import device.Device;

public class AirConditioner implements Device {
    @Override
    public void on() {
        System.out.println("AC on");
    }

    @Override
    public void off() {
        System.out.println("AC off");
    }

    @Override
    public void up() {
        System.out.println("Temperature increase by 1");
    }

    @Override
    public void down() {
        System.out.println("Temperature decreased by 1");
    }
}
