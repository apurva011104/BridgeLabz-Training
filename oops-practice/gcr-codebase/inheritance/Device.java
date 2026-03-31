public class Device {
    
    String deviceId;
    String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus(){
        System.out.println("Device "+deviceId+" Status: "+status);
    }
}

class Thermostat extends Device{

    private double temperatureSetting;

    Thermostat(String thermostatId, String status, double temperatureSetting){
        super(thermostatId, status);
        this.temperatureSetting = temperatureSetting;
    }

    //Getter and setter for temperatureSetting
    public double getTemperatureSetting(){
        return temperatureSetting;
    }

    public void setTemperatureSetting(double temperatureSetting){
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus(){
        System.out.println("Thermostat "+deviceId+" Status: "+status);
        System.out.printf("Thermostat %s Tempearture Setting(in degree Celsius): %.1f%n",deviceId,temperatureSetting);
    }

}

//Main class for testing
class Main{
    public static void main(String[] args) {
        Device device1 = new Device("DEV0018","Not Connected");

        Thermostat thermostat1 = new Thermostat("TS153","Connected",27.5);

        device1.displayStatus();
        System.out.println();
        thermostat1.displayStatus();
    }
}