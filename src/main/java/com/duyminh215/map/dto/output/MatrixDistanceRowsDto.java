package com.duyminh215.map.dto.output;

import com.duyminh215.map.utils.Utils;
import com.graphhopper.ResponsePath;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.InstructionList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatrixDistanceRowsDto {
    private String status;
    private List<ElementMatrixDistanceDto> rows;

    public void loadFromResponsePath(ResponsePath responsePath){
        this.status = "OK";
        getRowsFromResponsePath(responsePath);
    }

    public void getRowsFromResponsePath(ResponsePath responsePath){
        List<ElementMatrixDistanceDto> rowDatas = new ArrayList<>();
        InstructionList instructions = responsePath.getInstructions();
        for(Instruction instruction : instructions){
            ElementMatrixDistanceDto row = new ElementMatrixDistanceDto();
            row.loadDataFromInstruction(instruction);
            rowDatas.add(row);
        }
        this.rows = rowDatas;
    }
}
