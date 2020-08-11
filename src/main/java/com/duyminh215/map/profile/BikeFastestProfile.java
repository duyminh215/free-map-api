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
public class BikeFastestProfile extends MapProfile{
    private static BikeFastestProfile bikeFastestProfile;
    public static BikeFastestProfile getInstance(){
        if(bikeFastestProfile != null){
            return bikeFastestProfile;
        }
        bikeFastestProfile = new BikeFastestProfile();
        hopper = new GraphHopperOSM().forServer();
        hopper.setDataReaderFile(GraphHopperConstants.OSM_FILE);
        hopper.setGraphHopperLocation(GraphHopperConstants.MAP_FOLDER);
        hopper.setEncodingManager(EncodingManager.create(GraphHopperConstants.PROFILE_BIKE));
        hopper.setProfiles(
                new Profile(GraphHopperConstants.PROFILE_BIKE)
                        .setVehicle(GraphHopperConstants.PROFILE_BIKE)
                        .setWeighting(GraphHopperConstants.WEIGHTING_FASTEST)
        );
        hopper.getCHPreparationHandler().setCHProfiles(
                new CHProfile(GraphHopperConstants.PROFILE_BIKE)
        );
        hopper.importOrLoad();
        return bikeFastestProfile;
    }
}
