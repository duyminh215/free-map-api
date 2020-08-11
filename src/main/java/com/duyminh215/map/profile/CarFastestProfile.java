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
public class CarFastestProfile extends MapProfile{
    private static CarFastestProfile carFastestProfile;
    public static CarFastestProfile getInstance(){
        if(carFastestProfile != null){
            return carFastestProfile;
        }
        carFastestProfile = new CarFastestProfile();
        hopper = new GraphHopperOSM().forServer();
        hopper.setDataReaderFile(GraphHopperConstants.OSM_FILE);
        hopper.setGraphHopperLocation(GraphHopperConstants.MAP_FOLDER);
        hopper.setEncodingManager(EncodingManager.create(GraphHopperConstants.PROFILE_CAR));
        hopper.setProfiles(getSupportedProfiles());
        hopper.getCHPreparationHandler().setCHProfiles(getSupportedCHProfiles());
        hopper.importOrLoad();
        return carFastestProfile;
    }

    public static List<Profile> getSupportedProfiles(){
        Profile bikeFastestProfile = new Profile(GraphHopperConstants.PROFILE_BIKE)
                .setVehicle(GraphHopperConstants.PROFILE_BIKE)
                .setWeighting(GraphHopperConstants.WEIGHTING_FASTEST);
        Profile bikeShortestProfile = new Profile(GraphHopperConstants.PROFILE_BIKE)
                .setVehicle(GraphHopperConstants.PROFILE_BIKE)
                .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST);
        Profile carFastestProfile = new Profile(GraphHopperConstants.PROFILE_CAR)
                .setVehicle(GraphHopperConstants.PROFILE_CAR)
                .setWeighting(GraphHopperConstants.WEIGHTING_FASTEST);
        Profile carShortestProfile = new Profile(GraphHopperConstants.PROFILE_CAR)
                .setVehicle(GraphHopperConstants.PROFILE_CAR)
                .setWeighting(GraphHopperConstants.WEIGHTING_FASTEST);
        Profile footFastestProfile = new Profile(GraphHopperConstants.PROFILE_FOOT)
                .setVehicle(GraphHopperConstants.PROFILE_FOOT)
                .setWeighting(GraphHopperConstants.WEIGHTING_FASTEST);
        Profile footShortestProfile = new Profile(GraphHopperConstants.PROFILE_FOOT)
                .setVehicle(GraphHopperConstants.PROFILE_FOOT)
                .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST);
        Profile motorcycleFastestProfile = new Profile(GraphHopperConstants.PROFILE_MOTORCYCLE)
                .setVehicle(GraphHopperConstants.PROFILE_MOTORCYCLE)
                .setWeighting(GraphHopperConstants.WEIGHTING_FASTEST);
        Profile motorcycleShortestProfile = new Profile(GraphHopperConstants.PROFILE_MOTORCYCLE)
                .setVehicle(GraphHopperConstants.PROFILE_MOTORCYCLE)
                .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST);
        List<Profile> supportedProfiles = new ArrayList<>();
        supportedProfiles.add(bikeFastestProfile);
        supportedProfiles.add(bikeShortestProfile);
        supportedProfiles.add(carFastestProfile);
        supportedProfiles.add(carShortestProfile);
        supportedProfiles.add(footFastestProfile);
        supportedProfiles.add(footShortestProfile);
        supportedProfiles.add(motorcycleFastestProfile);
        supportedProfiles.add(motorcycleShortestProfile);
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
