// Superclass
class Device {
    protected String deviceId;
    protected String status;  // e.g., "ON", "OFF"

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}


public class SmartHomeSystem {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("THERMO123", "ON", 22.5);
        t1.displayStatus();
    }
}
