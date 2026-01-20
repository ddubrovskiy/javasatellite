package project;

public abstract class Satellite {
    protected String name;
    protected boolean isActive;
    protected double batteryLevel;

    public Satellite(String name, double batteryLevel) {
        this.name = name;
        this.batteryLevel = batteryLevel;
        this.isActive = false;
    }

    public boolean activate() {
        if (batteryLevel > 0.2) {
            isActive = true;
            return true;
        }
        return false;
    }

    public void deactivate() {
        if (isActive) {
            isActive = false;
        }
    }

    public void consumeBattery(double amount) {
        batteryLevel -= amount;
        if (batteryLevel <= 0.2 && isActive) {
            deactivate();
        }
    }

    protected abstract void performMission();

    public String getName() { return name; }
    public boolean isActive() { return isActive; }
    public double getBatteryLevel() { return batteryLevel; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{name='" + name + "', isActive=" + isActive + 
               ", batteryLevel=" + String.format("%.2f", batteryLevel) + "}";
    }
}