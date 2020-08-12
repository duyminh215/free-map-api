package com.duyminh215.map.dto.output;

import com.duyminh215.map.utils.Utils;
import com.graphhopper.util.Instruction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElementMatrixDistanceDto {
    private String status;
    private ValueTextDto duration;
    private ValueTextDto distance;

    public void loadDataFromInstruction(Instruction instruction){
        this.status = "OK";
        loadDistance(instruction);
        loadDuration(instruction);
    }

    public void loadDuration(Instruction instruction){
        long timeInSecond = instruction.getTime()/1000;
        ValueTextDto durationValue = new ValueTextDto();
        durationValue.setValue(timeInSecond);
        durationValue.setText(Utils.convertNumberOfSecondToDisplayTime(timeInSecond));
        this.duration = durationValue;
    }

    public void loadDistance(Instruction instruction){
        double distanceInMeter = instruction.getDistance();
        ValueTextDto distanceValue = new ValueTextDto();
        distanceValue.setValue(instruction.getDistance());
        distanceValue.setText(Utils.convertNumberOfMeterToDisplayDistance(distanceInMeter));
        this.distance = distanceValue;
    }
}
