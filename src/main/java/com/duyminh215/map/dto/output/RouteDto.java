package com.duyminh215.map.dto.output;

import com.graphhopper.ResponsePath;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.InstructionList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    private Double distance;
    private long time;

    public void loadDataFromResponsePath(ResponsePath responsePath){
        this.time = responsePath.getTime()/1000;
        this.distance = responsePath.getDistance();
        this.summary = generateSummary();
        this.legs = getLegsFromResponsePath(responsePath);
    }

    public List<StepDto> getLegsFromResponsePath(ResponsePath responsePath){
        List<StepDto> steps = new ArrayList<>();
        int i = 0;
        InstructionList instructions = responsePath.getInstructions();
        for(Instruction instruction : instructions){
            StepDto stepDto = new StepDto();
            stepDto.loadDataFromInstruction(instruction);
            if(stepDto.getName() == null || stepDto.getName().isEmpty()){
                String nextStepName = getNameOfNextInstruction(instructions, i);
                if(!nextStepName.isEmpty()){
                    stepDto.setName(nextStepName);
                }else{
                    String previousStepName = getNameOfPreviousInstruction(instructions, i);
                    stepDto.setName(previousStepName);
                }
            }
            steps.add(stepDto);
            i++;
        }
        return steps;
    }

    private String getNameOfNextInstruction(InstructionList instructions, int index){
        if(index < instructions.size() - 1){
            index++;
            return instructions.get(index).getName();
        }
        return "";
    }

    private String getNameOfPreviousInstruction(InstructionList instructions, int index){
        if(index > 0){
            index--;
            return instructions.get(index).getName();
        }
        return "";
    }

    public String generateSummary(){
        return "distance = " + this.distance + "m, time = " + this.time + "s";
    }
}
