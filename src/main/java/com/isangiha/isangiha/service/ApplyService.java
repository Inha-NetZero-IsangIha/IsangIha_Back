package com.isangiha.isangiha.service;

import com.isangiha.isangiha.domain.Event;
import com.isangiha.isangiha.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final EventRepository eventRepository;

    public void save(Event event) {
        eventRepository.save(event);
    }

    public Event getEvent(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }
}