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
public class MotorcycleShortestProfile extends MapProfile{
    private static MotorcycleShortestProfile motorcycleShortestProfile;
    public static MotorcycleShortestProfile getInstance(){
        if(motorcycleShortestProfile != null){
            return motorcycleShortestProfile;
        }
        motorcycleShortestProfile = new MotorcycleShortestProfile();
        hopper = new GraphHopperOSM().forServer();
        hopper.setDataReaderFile(GraphHopperConstants.OSM_FILE);
        hopper.setGraphHopperLocation(GraphHopperConstants.MAP_FOLDER);
        hopper.setEncodingManager(EncodingManager.create(GraphHopperConstants.PROFILE_MOTORCYCLE));
        hopper.setProfiles(
                new Profile(GraphHopperConstants.PROFILE_MOTORCYCLE)
                        .setVehicle(GraphHopperConstants.PROFILE_MOTORCYCLE)
                        .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST)
        );
        hopper.getCHPreparationHandler().setCHProfiles(
                new CHProfile(GraphHopperConstants.PROFILE_MOTORCYCLE)
        );
        hopper.importOrLoad();
        return motorcycleShortestProfile;
    }
}
