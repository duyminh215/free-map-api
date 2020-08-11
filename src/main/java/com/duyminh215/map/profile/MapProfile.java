package com.duyminh215.map.profile;

import com.duyminh215.map.constant.GraphHopperConstants;
import com.graphhopper.GraphHopper;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import com.graphhopper.reader.osm.GraphHopperOSM;
import com.graphhopper.routing.util.EncodingManager;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapProfile {
    static GraphHopper hopper;
    public static GraphHopper getHopper() {
        return hopper;
    }
    public static void setHopper(GraphHopper hopper) {
        MapProfile.hopper = hopper;
    }

    private static MapProfile mapProfile;
    public static MapProfile getInstance(){
        if(mapProfile != null){
            return mapProfile;
        }
        mapProfile = new MapProfile();
        hopper = new GraphHopperOSM().forServer();
        hopper.setDataReaderFile(GraphHopperConstants.OSM_FILE);
        hopper.setGraphHopperLocation(GraphHopperConstants.MAP_FOLDER);
        hopper.setEncodingManager(EncodingManager.create(getSupportedEncodings()));
        hopper.setProfiles(getSupportedProfiles());
        hopper.getCHPreparationHandler().setCHProfiles(getSupportedCHProfiles());
        hopper.importOrLoad();
        return mapProfile;
    }

    public static String getSupportedEncodings(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = stringBuilder.append(GraphHopperConstants.PROFILE_CAR).append(",")
                .append(GraphHopperConstants.PROFILE_FOOT).append(",")
                .append(GraphHopperConstants.PROFILE_BIKE).append(",")
                .append(GraphHopperConstants.PROFILE_MOTORCYCLE).append(",");
        return stringBuilder.toString();
    }

    public static List<Profile> getSupportedProfiles(){
        Profile bikeProfile = new Profile(GraphHopperConstants.PROFILE_BIKE)
                .setVehicle(GraphHopperConstants.PROFILE_BIKE)
                .setWeighting(GraphHopperConstants.WEIGHTING_SHORT_FASTEST)
//                .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST)
                ;
        Profile carProfile = new Profile(GraphHopperConstants.PROFILE_CAR)
                .setVehicle(GraphHopperConstants.PROFILE_CAR)
                .setWeighting(GraphHopperConstants.WEIGHTING_SHORT_FASTEST)
//                .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST)
                ;
        Profile footProfile = new Profile(GraphHopperConstants.PROFILE_FOOT)
                .setVehicle(GraphHopperConstants.PROFILE_FOOT)
                .setWeighting(GraphHopperConstants.WEIGHTING_SHORT_FASTEST)
//                .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST)
                ;
        Profile motorcycleProfile = new Profile(GraphHopperConstants.PROFILE_MOTORCYCLE)
                .setVehicle(GraphHopperConstants.PROFILE_MOTORCYCLE)
                .setWeighting(GraphHopperConstants.WEIGHTING_SHORT_FASTEST)
//                .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST)
                ;
        List<Profile> supportedProfiles = new ArrayList<>();
        supportedProfiles.add(bikeProfile);
        supportedProfiles.add(carProfile);
        supportedProfiles.add(footProfile);
        supportedProfiles.add(motorcycleProfile);
        return supportedProfiles;
    }

    public static List<CHProfile> getSupportedCHProfiles(){
        CHProfile carProfile = new CHProfile(GraphHopperConstants.PROFILE_CAR);
        CHProfile bikeProfile = new CHProfile(GraphHopperConstants.PROFILE_BIKE);
        CHProfile footProfile = new CHProfile(GraphHopperConstants.PROFILE_FOOT);
        CHProfile motorcycleProfile = new CHProfile(GraphHopperConstants.PROFILE_MOTORCYCLE);
        List<CHProfile> supportedCHProfiles = new ArrayList<>();
        supportedCHProfiles.add(carProfile);
        supportedCHProfiles.add(bikeProfile);
        supportedCHProfiles.add(footProfile);
        supportedCHProfiles.add(motorcycleProfile);
        return supportedCHProfiles;
    }
}
