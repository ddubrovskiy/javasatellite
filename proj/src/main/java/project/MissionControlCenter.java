package project;

import java.util.ArrayList;
import java.util.List;

public class MissionControlCenter {
    private String centerName;
    private List<String> receivedData = new ArrayList<>();
    private List<String> receivedImages = new ArrayList<>();

    public MissionControlCenter(String name) {
        this.centerName = name;
    }

    public void receiveData(String satelliteName, double dataAmount) {
        String record = String.format("[%s] Data received from %s: %.1f Mbit", 
                                     centerName, satelliteName, dataAmount);
        receivedData.add(record);
        System.out.println(record);
    }

    public void receiveImage(String satelliteName, String imageDetails) {
        String record = String.format("[%s] Image received from %s: %s", 
                                     centerName, satelliteName, imageDetails);
        receivedImages.add(record);
        System.out.println(record);
    }

    public void processData() {
        System.out.println("\n=== DATA PROCESSING AT CENTER '" + centerName + "' ===");
        System.out.println("Total data packets received: " + receivedData.size());
        System.out.println("Total images received: " + receivedImages.size());
        
        if (!receivedData.isEmpty()) {
            System.out.println("\nDetails of received data:");
            for (String data : receivedData) {
                System.out.println(data);
            }
        }
        
        if (!receivedImages.isEmpty()) {
            System.out.println("\nDetails of received images:");
            for (String image : receivedImages) {
                System.out.println(image);
            }
        }
    }

    public String getCenterName() {
        return centerName;
    }
}