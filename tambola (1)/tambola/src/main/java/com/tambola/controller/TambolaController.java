package com.tambola.controller;

import com.tambola.dtos.TicketSetsResponse;
import com.tambola.mysql.models.TicketSets;
import com.tambola.service.TambolaService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TambolaController {

    @NonNull
    private final TambolaService tambolaService;

    public TambolaController(@NonNull TambolaService tambolaService) {
        this.tambolaService = tambolaService;
    }

    @PostMapping("/create_tambola_set/{numberOfSet}")
    public void createTambolaSet(@PathVariable @NonNull Integer numberOfSet) {
        tambolaService.createTambola(numberOfSet);
    }

    @GetMapping("/{setId}")
    public TicketSetsResponse getTambolaSet(@PathVariable @NonNull Integer setId) {
        TicketSetsResponse response = new TicketSetsResponse();
        response.setTickets(tambolaService.getTambola(setId));
        return response;
    }
}
