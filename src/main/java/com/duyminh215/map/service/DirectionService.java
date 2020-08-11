package com.duyminh215.map.service;

import com.duyminh215.map.dto.input.DirectionInputDto;
import com.duyminh215.map.dto.input.Point;
import com.duyminh215.map.dto.output.DirectionDto;
import com.duyminh215.map.profile.MapProfile;
import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class DirectionService {

    private static final Logger logger = LogManager.getLogger(DirectionService.class);

    public DirectionDto direction(DirectionInputDto directionInputDto){
        MapProfile mapProfile = MapProfile.getInstance();
        Point originPoint = convertPointFromInput(directionInputDto.getOrigin());
        Point destinationPoint = convertPointFromInput(directionInputDto.getDestination());
        GHRequest req = new GHRequest(originPoint.getLat(), originPoint.getLng(),
                destinationPoint.getLat(), destinationPoint.getLng())
                .setProfile(directionInputDto.getVehicle())
                .setLocale(Locale.US);
        GraphHopper graphHopper = mapProfile.getHopper();
        GHResponse rsp = graphHopper.route(req);
        if(rsp.hasErrors()) {
            logger.error(rsp.getErrors());
        }
        ResponsePath path = rsp.getBest();
        DirectionDto directionDto = new DirectionDto();
        directionDto.setResponsePath(path);
        return directionDto;
    }

    public Point convertPointFromInput(String input){
        if(input == null || input.isEmpty()){
            return new Point();
        }
        String[] coordinates = input.split(",");
        if(coordinates == null || coordinates.length == 0){
            return new Point();
        }
        double latitude = Double.parseDouble(coordinates[0].trim());
        double longitude = Double.parseDouble(coordinates[1].trim());
        return new Point(latitude, longitude);
    }


}
