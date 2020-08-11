package com.duyminh215.map.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {
    private String summary;
    private Object bound;
    private List<StepDto> legs;
    private Object warnings;
    private Object waypoint_order;
}
