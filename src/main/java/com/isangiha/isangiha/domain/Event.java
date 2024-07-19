package com.isangiha.isangiha.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Container> containers;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Coordinate> coordinates;
}