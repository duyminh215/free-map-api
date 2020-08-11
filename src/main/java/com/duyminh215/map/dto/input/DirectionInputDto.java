package com.duyminh215.map.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DirectionInputDto {
    private String origin;
    private String destination;
    private Boolean alternatives;
    private String vehicle;
    private String type;
}
