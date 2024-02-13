package com.tambola.service.impl;

import com.tambola.mysql.impl.TambolaTicketsRepositoryImpl;
import com.tambola.mysql.models.TicketSets;
import com.tambola.service.TambolaService;
import com.tambola.service.strategy.TicketGenerationStartegy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TambolaServiceImpl implements TambolaService {

    @NonNull
    private final TambolaTicketsRepositoryImpl tambolaTicketsRepository;

    @NonNull
    @Qualifier("strategy_one")
    private final TicketGenerationStartegy ticketGenerationStartegy;

    public TambolaServiceImpl(@NonNull TambolaTicketsRepositoryImpl tambolaTicketsRepository, TicketGenerationStartegy ticketGenerationStartegy) {
        this.tambolaTicketsRepository = tambolaTicketsRepository;
        this.ticketGenerationStartegy = ticketGenerationStartegy;
    }

    public void createTambola(int n) {
        List<TicketSets> ticketSets = ticketGenerationStartegy.generateTicket(n);
        tambolaTicketsRepository.insertTicketSets(ticketSets);
    }

    public Map<String, int[][]> getTambola(int setId) {
        Map<String, int[][]> response = new HashMap<>();
        List<TicketSets> ticketSets = tambolaTicketsRepository.getTicketSets(setId);
        ticketSets.stream().forEach(ticketSets1 -> {
            response.put(ticketSets1.getId().toString(), ticketSets1.getTicket().getTicket());
        });
        return response;
    }
}
