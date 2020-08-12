package com.duyminh215.map.controller;

import com.duyminh215.map.dto.input.DirectionInputDto;
import com.duyminh215.map.dto.input.MatrixDistanceInputDto;
import com.duyminh215.map.model.response.ResponseFactory;
import com.duyminh215.map.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps/api")
public class DirectionController {

    @Autowired
    private DirectionService directionService;
    @Autowired
    private ResponseFactory responseFactory;

    @GetMapping("/direction")
    public ResponseEntity<?> direction(String origin, String destination,
                                       Boolean alternatives, String vehicle, String type){
        DirectionInputDto directionInputDto = new DirectionInputDto(origin, destination, alternatives, vehicle, type);
        return responseFactory.success(directionService.direction(directionInputDto));
    }

    @GetMapping("/distance-matrix")
    public ResponseEntity<?> distanceMatrix(String origins, String destinations){
        MatrixDistanceInputDto matrixDistanceInputDto = new MatrixDistanceInputDto(origins, destinations);
        return responseFactory.success(directionService.matrixDistance(matrixDistanceInputDto));
    }
}
