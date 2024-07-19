package com.isangiha.isangiha.controller;

import com.isangiha.isangiha.domain.Event;
import com.isangiha.isangiha.dto.event.EventWithDetailsDto;
import com.isangiha.isangiha.service.ApplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
@Slf4j
public class ApplyController {

    private final ApplyService applyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventWithDetailsDto> getAllEvents() {
        return applyService.getAllEvents().stream()
                .map(applyService::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public EventWithDetailsDto getEventById(@PathVariable Long eventId) {
        Event event = applyService.getEventById(eventId);
        return applyService.convertToDto(event);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventWithDetailsDto apply(@RequestBody Event event) {
        Event savedEvent = applyService.save(event);
        return applyService.convertToDto(savedEvent);
    }
}