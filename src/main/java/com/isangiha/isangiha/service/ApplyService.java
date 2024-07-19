package com.isangiha.isangiha.service;

import com.isangiha.isangiha.domain.Container;

import com.isangiha.isangiha.dto.ContainerDto;

import com.isangiha.isangiha.dto.event.CoordinateDto;
import com.isangiha.isangiha.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ApplyService {

    @Autowired
    private ContainerRepository containerRepository;

    public ContainerDto getContainerDto(Long containerId) {
        Container container = containerRepository.findById(containerId).orElseThrow(() -> new RuntimeException("Container not found"));
        ContainerDto containerDto = new ContainerDto();
        containerDto.setId(container.getId());
        containerDto.setContainerType(container.getContainerType());
        containerDto.setQuantity(container.getQuantity());
        containerDto.setCoordinates(container.getCoordinates().stream().map(coordinate -> {
            CoordinateDto coordinateDto = new CoordinateDto();
            coordinateDto.setLatitude(coordinate.getLatitude());
            coordinateDto.setLongitude(coordinate.getLongitude());
            coordinateDto.setName(coordinate.getName());
            return coordinateDto;
        }).collect(Collectors.toList()));
        return containerDto;
    }
}