package com.isangiha.isangiha.repository;

import com.isangiha.isangiha.domain.Event;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @EntityGraph(value = "Event.containersAndCoordinates", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT e FROM Event e WHERE e.eventId = :eventId")
    Event findByIdWithDetails(@Param("eventId") Long eventId);

    @EntityGraph(value = "Event.containersAndCoordinates", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT e FROM Event e")
    List<Event> findAllWithDetails();
}