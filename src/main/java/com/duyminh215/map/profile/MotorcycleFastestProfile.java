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
public class MotorcycleFastestProfile extends MapProfile{
    private static MotorcycleFastestProfile motorcycleFastestProfile;

    public static MotorcycleFastestProfile getInstance(){
        if(motorcycleFastestProfile != null){
            return motorcycleFastestProfile;
        }
        motorcycleFastestProfile = new MotorcycleFastestProfile();
        hopper = new GraphHopperOSM().forServer();
        hopper.setDataReaderFile(GraphHopperConstants.OSM_FILE);
        hopper.setGraphHopperLocation(GraphHopperConstants.MAP_FOLDER);
        hopper.setEncodingManager(EncodingManager.create(GraphHopperConstants.PROFILE_MOTORCYCLE));
        hopper.setProfiles(
                new Profile(GraphHopperConstants.PROFILE_MOTORCYCLE)
                        .setVehicle(GraphHopperConstants.PROFILE_MOTORCYCLE)
                        .setWeighting(GraphHopperConstants.WEIGHTING_FASTEST)
        );
        hopper.getCHPreparationHandler().setCHProfiles(
                new CHProfile(GraphHopperConstants.PROFILE_MOTORCYCLE)
        );
        hopper.importOrLoad();
        return motorcycleFastestProfile;
    }
}
