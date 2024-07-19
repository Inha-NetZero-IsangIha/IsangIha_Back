package com.isangiha.isangiha.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    private Date startDate;
    private Date endDate;
    private Date deliveryDate;
    private Date collectionDate;
    private String location;
    private Integer cluster;
    private Boolean meeting;
    private Date meetingDate;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Container> containers;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<ContainerWithCoordinates> containersWithCoordinates;
}