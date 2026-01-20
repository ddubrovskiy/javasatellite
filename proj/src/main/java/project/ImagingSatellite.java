package project;

public class ImagingSatellite extends Satellite {
    private double resolution;
    private int photosTaken;

    public ImagingSatellite(String name, double batteryLevel, double resolution) {
        super(name, batteryLevel);
        this.resolution = resolution;
        this.photosTaken = 0;
    }

    public double getResolution() {
        return resolution;
    }

    public int getPhotosTaken() {
        return photosTaken;
    }

    private void takePhoto(MissionControlCenter center) {
        if (isActive) {
            photosTaken++;
            String imageDetails = String.format("Resolution: %.1f m/pixel, #%d", resolution, photosTaken);
            System.out.println(name + ": Snapshot #" + photosTaken + " taken!");
            if (center != null) {
                center.receiveImage(name, imageDetails);
            }
        }
    }

    @Override
    protected void performMission() {
        if (!isActive) {
            System.out.println("STOP " + name + ": Cannot perform imaging - not active");
            return;
        }
        System.out.println(name + ": Imaging territory with resolution " + resolution + " m/pixel");
        takePhoto(null);
        consumeBattery(0.08);
    }

    public void performMissionWithCenter(MissionControlCenter center) {
        if (!isActive) {
            System.out.println("STOP " + name + ": Cannot perform imaging - not active");
            return;
        }
        System.out.println(name + ": Imaging territory with resolution " + resolution + " m/pixel");
        takePhoto(center);
        consumeBattery(0.08);
    }

    @Override
    public String toString() {
        return "ImagingSatellite{resolution=" + resolution + ", photosTaken=" + photosTaken +
                ", name='" + name + "', isActive=" + isActive + ", batteryLevel=" + String.format("%.2f", batteryLevel) + "}";
    }
}