package com.duyminh215.map.dto.output;

import com.duyminh215.map.dto.input.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StepDto {
    private String travel_mode;
    private Point start_location;
    private Point end_location;
    private Object polyline;
    private ValueTextDto duration;
    private ValueTextDto distance;
}
