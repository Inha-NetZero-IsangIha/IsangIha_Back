package com.isangiha.isangiha.dto.event;

import lombok.Data;

import java.util.List;

@Data
public class EventWithDetailsDto {
    private Long eventId;
    private String enterpriseName;
    private String eventName;
    private Integer headcount;
    private String startDate;
    private String endDate;
    private String deliveryDate;
    private String collectionDate;
    private String location;
    private String cluster;  // Integer에서 String으로 변경
    private String meeting;
    private String meetingDate;
    private List<ContainerWithCoordinatesDto> containersWithCoordinates;
}