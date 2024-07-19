package com.isangiha.isangiha.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "container_with_coordinates")
public class ContainerWithCoordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long containerWithCoordinatesId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String containerType;
    private Integer quantity;

    @OneToMany(mappedBy = "containerWithCoordinates", cascade = CascadeType.ALL)
    private List<Coordinate> coordinates;

    public ContainerWithCoordinates(Event event, String containerType, Integer quantity, List<Coordinate> coordinates) {
        this.event = event;
        this.containerType = containerType;
        this.quantity = quantity;
        this.coordinates = coordinates;
    }
}