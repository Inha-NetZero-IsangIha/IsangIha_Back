package com.isangiha.isangiha.controller;

import com.isangiha.isangiha.domain.Event;
import com.isangiha.isangiha.service.ApplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
@Slf4j
public class ApplyController {

    private final ApplyService applyService;

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public Event getEvent(@PathVariable Long eventId) {
        return applyService.getEvent(eventId);
    }

    @PostMapping
    @ResponseBody
    public Event apply(@RequestBody Event event) {
        applyService.save(event);
        return event;
    }
}