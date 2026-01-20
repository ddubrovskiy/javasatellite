package project;

import java.util.ArrayList;
import java.util.List;

public class SatelliteConstellation {
    private String constellationName;
    private List<Satellite> satellites;

    public SatelliteConstellation(String name) {
        this.constellationName = name;
        this.satellites = new ArrayList<>();
    }

    public void addSatellite(Satellite satellite) {
        satellites.add(satellite);
        System.out.println(satellite.getName() + " added to constellation '" + constellationName + "'");
    }

    public void executeAllMissions() {
        System.out.println("\nEXECUTING MISSIONS FOR CONSTELLATION " + constellationName.toUpperCase());
        System.out.println("==================================================");
        for (Satellite sat : satellites) {
            sat.performMission();
        }
    }

    public void executeAllMissions(MissionControlCenter center) {
        System.out.println("\nEXECUTING MISSIONS WITH DATA TRANSMISSION TO CENTER " + center.getCenterName());
        System.out.println("==================================================");
        for (Satellite sat : satellites) {
            if (sat instanceof ImagingSatellite) {
                ((ImagingSatellite) sat).performMissionWithCenter(center);
            } else if (sat instanceof CommunicationSatellite) {
                ((CommunicationSatellite) sat).performMissionWithCenter(center);
            } else {
                sat.performMission();
            }
        }
    }

    public List<Satellite> getSatellites() {
        return new ArrayList<>(satellites);
    }

    public String getName() {
        return constellationName;
    }
}