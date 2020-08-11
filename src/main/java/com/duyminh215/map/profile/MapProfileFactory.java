package com.duyminh215.map.profile;

import com.duyminh215.map.constant.GraphHopperConstants;
import com.graphhopper.GraphHopper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MapProfileFactory {
    public MapProfile createGraphHopper(String vehicle, String weighting){
        MapProfile mapProfile = null;
        if(GraphHopperConstants.PROFILE_CAR.equals(vehicle)){
            if(GraphHopperConstants.WEIGHTING_FASTEST.equals(weighting)){
                mapProfile = CarFastestProfile.getInstance();
            }else if(GraphHopperConstants.WEIGHTING_SHORTEST.equals(weighting)){
                mapProfile = CarShortestProfile.getInstance();
            }
        }else if(GraphHopperConstants.PROFILE_BIKE.equals(vehicle)){
            if(GraphHopperConstants.WEIGHTING_FASTEST.equals(weighting)){
                mapProfile = BikeFastestProfile.getInstance();
            }else if(GraphHopperConstants.WEIGHTING_SHORTEST.equals(weighting)){
                mapProfile = BikeShortestProfile.getInstance();
            }
        }else if(GraphHopperConstants.PROFILE_FOOT.equals(vehicle)){
            if(GraphHopperConstants.WEIGHTING_FASTEST.equals(weighting)){
                mapProfile = FootFastestProfile.getInstance();
            }else if(GraphHopperConstants.WEIGHTING_SHORTEST.equals(weighting)){
                mapProfile = FootShortestProfile.getInstance();
            }
        }else if(GraphHopperConstants.PROFILE_MOTORCYCLE.equals(vehicle)){
            if(GraphHopperConstants.WEIGHTING_FASTEST.equals(weighting)){
                mapProfile = MotorcycleFastestProfile.getInstance();
            }else if(GraphHopperConstants.WEIGHTING_SHORTEST.equals(weighting)){
                mapProfile = MotorcycleShortestProfile.getInstance();
            }
        }

        if(mapProfile == null){
            mapProfile = MotorcycleShortestProfile.getInstance();
        }
        return mapProfile;
    }
}
