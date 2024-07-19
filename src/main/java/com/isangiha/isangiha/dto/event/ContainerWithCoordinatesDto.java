package com.isangiha.isangiha.dto.event;



import lombok.Data;

import java.util.List;

@Data
public class ContainerWithCoordinatesDto {
    private String containerType;
    private Integer quantity;
    private List<CoordinateDto> coordinates;
}