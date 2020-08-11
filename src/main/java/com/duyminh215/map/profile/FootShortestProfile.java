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
public class FootShortestProfile extends MapProfile{
    private static FootShortestProfile footShortestProfile;
    public static FootShortestProfile getInstance(){
        if(footShortestProfile != null){
            return footShortestProfile;
        }
        footShortestProfile = new FootShortestProfile();
        hopper = new GraphHopperOSM().forServer();
        hopper.setDataReaderFile(GraphHopperConstants.OSM_FILE);
        hopper.setGraphHopperLocation(GraphHopperConstants.MAP_FOLDER);
        hopper.setEncodingManager(EncodingManager.create(GraphHopperConstants.PROFILE_FOOT));
        hopper.setProfiles(
                new Profile(GraphHopperConstants.PROFILE_FOOT)
                        .setVehicle(GraphHopperConstants.PROFILE_FOOT)
                        .setWeighting(GraphHopperConstants.WEIGHTING_SHORTEST)
        );
        hopper.getCHPreparationHandler().setCHProfiles(
                new CHProfile(GraphHopperConstants.PROFILE_FOOT)
        );
        hopper.importOrLoad();
        return footShortestProfile;
    }
}
