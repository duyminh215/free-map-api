package com.duyminh215.map.service;

import com.duyminh215.map.constant.GraphHopperConstants;
import com.duyminh215.map.dto.input.DirectionInputDto;
import com.duyminh215.map.dto.input.MatrixDistanceInputDto;
import com.duyminh215.map.dto.input.Point;
import com.duyminh215.map.dto.output.DirectionDto;
import com.duyminh215.map.dto.output.MatrixDistanceRowsDto;
import com.duyminh215.map.dto.output.RouteDto;
import com.duyminh215.map.profile.MapProfile;
import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DirectionService {

    private static final Logger logger = LogManager.getLogger(DirectionService.class);

    public DirectionDto direction(DirectionInputDto directionInputDto){
        GraphHopper graphHopper = getGraphHopper();
        Point originPoint = convertPointFromInput(directionInputDto.getOrigin());
        Point destinationPoint = convertPointFromInput(directionInputDto.getDestination());
        GHRequest req = new GHRequest(originPoint.getLat(), originPoint.getLng(),
                destinationPoint.getLat(), destinationPoint.getLng())
                .setProfile(directionInputDto.getVehicle())
                .setLocale(Locale.US);
        GHResponse rsp = graphHopper.route(req);
        if(rsp.hasErrors()) {
            logger.error(rsp.getErrors());
        }
        DirectionDto directionDto = new DirectionDto();
        List<RouteDto> routes = new ArrayList<>();
        if(rsp.getAll() != null && !rsp.getAll().isEmpty()){
            for(ResponsePath responsePath : rsp.getAll()){
                RouteDto routeDto = new RouteDto();
                routeDto.setVehicle(directionInputDto.getVehicle());
                routeDto.loadDataFromResponsePath(responsePath);
                routes.add(routeDto);
            }
        }
        directionDto.setRoutes(routes);
        return directionDto;
    }

    private Point convertPointFromInput(String input){
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

    public MatrixDistanceRowsDto matrixDistance(MatrixDistanceInputDto matrixDistanceInputDto){
        GraphHopper graphHopper = getGraphHopper();
        Point originPoint = convertPointFromInput(matrixDistanceInputDto.getOrigins());
        Point destinationPoint = convertPointFromInput(matrixDistanceInputDto.getDestinations());
        GHRequest req = new GHRequest(originPoint.getLat(), originPoint.getLng(),
                destinationPoint.getLat(), destinationPoint.getLng())
                .setProfile(GraphHopperConstants.PROFILE_MOTORCYCLE)
                .setLocale(Locale.US);
        GHResponse rsp = graphHopper.route(req);
        if(rsp.hasErrors()) {
            logger.error(rsp.getErrors());
        }
        ResponsePath path = rsp.getBest();
        MatrixDistanceRowsDto matrixDistanceRowsDto = new MatrixDistanceRowsDto();
        matrixDistanceRowsDto.loadFromResponsePath(path);
        return matrixDistanceRowsDto;
    }

    private GraphHopper getGraphHopper(){
        MapProfile.getInstance();
        return  MapProfile.getHopper();
    }

}
