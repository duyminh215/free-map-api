package com.duyminh215.map.dto.output;

import com.graphhopper.ResponsePath;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DirectionDto {
    private List geocoded_waypoints;
    private List<RouteDto> routes;
}
