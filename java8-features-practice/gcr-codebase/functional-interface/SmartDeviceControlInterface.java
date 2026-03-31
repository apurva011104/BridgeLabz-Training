public class SmartDeviceControlInterface{
    public static void main(String[] args) {
        Device device1 = new Lights();
        Device device2 = new AirConditioner();
        Device device3 = new Television();

        Device[] devices = {device1,device2,device3};

        for(Device device: devices){
            device.turnOn();
            device.turnOff();
        }
    }
}

interface Device{
    void turnOn();
    void turnOff();
}

class Lights implements Device{

    @Override
    public void turnOn(){
        System.out.println("Lights on!");
    }

    @Override
    public void turnOff(){
        System.out.println("Lights off!");
    }

}


class AirConditioner implements Device{

    @Override
    public void turnOn(){
        System.out.println("AC on");
    }

    @Override
    public void turnOff(){
        System.out.println("AC off");
    }

}

class Television implements Device{

    @Override
    public void turnOn(){
        System.out.println("TV on");
    }

    @Override
    public void turnOff(){
        System.out.println("TV off");
    }

}