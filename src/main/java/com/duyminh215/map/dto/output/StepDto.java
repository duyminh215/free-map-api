package com.duyminh215.map.dto.output;

import com.duyminh215.map.dto.input.Point;
import com.duyminh215.map.utils.Utils;
import com.graphhopper.util.Instruction;
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
    private String name;
    private ValueTextDto duration;
    private ValueTextDto distance;

    public void loadNameFromInstruction(Instruction instruction){
        this.name = instruction.getName();
    }

    public void loadDataFromInstruction(Instruction instruction){
        loadNameFromInstruction(instruction);
        loadDuration(instruction);
        loadDistance(instruction);
    }

    public void loadDuration(Instruction instruction){
        long timeInSecond = instruction.getTime()/1000;
        ValueTextDto duration = new ValueTextDto();
        duration.setValue(timeInSecond);
        duration.setText(Utils.convertNumberOfSecondToDisplayTime(timeInSecond));
        this.duration = duration;
    }

    public void loadDistance(Instruction instruction){
        double distanceInMeter = instruction.getDistance();
        ValueTextDto distance = new ValueTextDto();
        distance.setValue(instruction.getDistance());
        distance.setText(Utils.convertNumberOfMeterToDisplayDistance(distanceInMeter));
        this.distance = distance;
    }
}
