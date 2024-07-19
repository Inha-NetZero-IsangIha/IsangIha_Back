package com.isangiha.isangiha.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "coordinate")
public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coordinateId;

    @ManyToOne
    @JoinColumn(name = "container_with_coordinates_id")
    private ContainerWithCoordinates containerWithCoordinates;

    private String name;
    private String latitude;
    private String longitude;

    public Coordinate(ContainerWithCoordinates containerWithCoordinates, String name, String latitude, String longitude) {
        this.containerWithCoordinates = containerWithCoordinates;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}