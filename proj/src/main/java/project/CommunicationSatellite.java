package project;

public class CommunicationSatellite extends Satellite {
    private double bandWidth;

    public CommunicationSatellite(String name, double batteryLevel, double bandWidth) {
        super(name, batteryLevel);
        this.bandWidth = bandWidth;
    }

    public double getBandwidth() {
        return bandWidth;
    }

    private void sendData(double dataAmount, MissionControlCenter center) {
        if (isActive) {
            System.out.println(name + ": Sent " + dataAmount + " Mbit of data!");
            if (center != null) {
                center.receiveData(name, dataAmount);
            }
        }
    }

    @Override
    protected void performMission() {
        if (!isActive) {
            System.out.println("STOP " + name + ": Cannot transmit data - not active");
            return;
        }
        System.out.println(name + ": Transmitting data at " + bandWidth + " Mbit/s");
        sendData(bandWidth, null);
        consumeBattery(0.05);
    }

    public void performMissionWithCenter(MissionControlCenter center) {
        if (!isActive) {
            System.out.println("STOP " + name + ": Cannot transmit data - not active");
            return;
        }
        System.out.println(name + ": Transmitting data at " + bandWidth + " Mbit/s");
        sendData(bandWidth, center);
        consumeBattery(0.05);
    }

    @Override
    public String toString() {
        return "CommunicationSatellite{bandwidth=" + bandWidth +
                ", name='" + name + "', isActive=" + isActive + ", batteryLevel=" + String.format("%.2f", batteryLevel) + "}";
    }
}