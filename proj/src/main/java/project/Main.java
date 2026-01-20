package project;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("LAUNCHING SATELLITE CONSTELLATION MANAGEMENT SYSTEM");
        System.out.println("============================================================");

        System.out.println("\nCREATING SPECIALIZED SATELLITES:");
        System.out.println("---------------------------------------------");

        CommunicationSatellite comm1 = new CommunicationSatellite("ComSat-1", 0.85, 500.0);
        CommunicationSatellite comm2 = new CommunicationSatellite("ComSat-2", 0.75, 1000.0);
        ImagingSatellite img1 = new ImagingSatellite("ImagingSat-1", 0.92, 2.5);
        ImagingSatellite img2 = new ImagingSatellite("ImagingSat-2", 0.45, 1.0);
        ImagingSatellite img3 = new ImagingSatellite("ImagingSat-3", 0.15, 0.5);

        System.out.println("Created satellite: " + comm1.getName() + " (battery: " + (int)(comm1.getBatteryLevel() * 100) + "%)");
        System.out.println("Created satellite: " + comm2.getName() + " (battery: " + (int)(comm2.getBatteryLevel() * 100) + "%)");
        System.out.println("Created satellite: " + img1.getName() + " (battery: " + (int)(img1.getBatteryLevel() * 100) + "%)");
        System.out.println("Created satellite: " + img2.getName() + " (battery: " + (int)(img2.getBatteryLevel() * 100) + "%)");
        System.out.println("Created satellite: " + img3.getName() + " (battery: " + (int)(img3.getBatteryLevel() * 100) + "%)");

        System.out.println("\n---------------------------------------------");
        SatelliteConstellation constellation = new SatelliteConstellation("GlobalNet");
        System.out.println("Created satellite constellation: " + constellation.getName());
        System.out.println("---------------------------------------------");

        System.out.println("\nBUILDING CONSTELLATION:");
        System.out.println("-----------------------------------");
        constellation.addSatellite(comm1);
        constellation.addSatellite(comm2);
        constellation.addSatellite(img1);
        constellation.addSatellite(img2);
        constellation.addSatellite(img3);

        System.out.println("\n-----------------------------------");
        List<Satellite> satellites = constellation.getSatellites();
        System.out.println("Constellation composition:");
        for (Satellite sat : satellites) {
            System.out.println(sat);
        }
        System.out.println("-----------------------------------");

        System.out.println("\nACTIVATING SATELLITES:");
        System.out.println("-------------------------");
        for (Satellite sat : satellites) {
            if (sat.activate()) {
                System.out.println("OK " + sat.getName() + ": Activation successful");
            } else {
                System.out.println("STOP " + sat.getName() + ": Activation failed (battery level: " +
                        (int)(sat.getBatteryLevel() * 100) + "%)");
            }
        }

        MissionControlCenter missionCenter = new MissionControlCenter("EarthStation");
        System.out.println("\nCreated mission control center: " + missionCenter.getCenterName());
        System.out.println("=============================================");

        constellation.executeAllMissions(missionCenter);
        missionCenter.processData();

        System.out.println("\nFINAL SATELLITE STATES:");
        System.out.println("-----------------------------------");
        for (Satellite sat : satellites) {
            System.out.println(sat);
        }
        System.out.println("\nSYSTEM OPERATION COMPLETED SUCCESSFULLY");
    }
}