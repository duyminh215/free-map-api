package com.duyminh215.map.profile;

import com.duyminh215.map.constant.GraphHopperConstants;
import com.graphhopper.GraphHopper;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import com.graphhopper.reader.osm.GraphHopperOSM;
import com.graphhopper.routing.util.EncodingManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarShortestProfile extends MapProfile{
    private static CarShortestProfile carShortestProfile;
    public static CarShortestProfile getInstance(){
        if(carShortestProfile != null){
            return carShortestProfile;
        }
        carShortestProfile = new CarShortestProfile();
        hopper = new GraphHopperOSM().forServer();
        hopper.setDataReaderFile(GraphHopperConstants.OSM_FILE);
        hopper.setGraphHopperLocation(GraphHopperConstants.MAP_FOLDER);
        hopper.setEncodingManager(EncodingManager.create(GraphHopperConstants.PROFILE_CAR));
        hopper.setProfiles(
                new Profile(GraphHopperConstants.PROFILE_CAR)
                        .setVehicle(GraphHopperConstants.PROFILE_CAR)
                        .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST)
        );
        hopper.getCHPreparationHandler().setCHProfiles(
                new CHProfile(GraphHopperConstants.PROFILE_CAR)
        );
        hopper.importOrLoad();
        return carShortestProfile;
    }
}
