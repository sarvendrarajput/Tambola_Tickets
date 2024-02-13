package com.tambola.mysql.impl;

import com.tambola.dal.TambolaTicketsRepository;
import com.tambola.mysql.MySqlTambolaTicketsRepository;
import com.tambola.mysql.models.TicketSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TambolaTicketsRepositoryImpl implements TambolaTicketsRepository {

    @Autowired
    private final MySqlTambolaTicketsRepository ticketsRepository;

    public TambolaTicketsRepositoryImpl(MySqlTambolaTicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public void insertTicketSets(List<TicketSets> ticketSets) {
        ticketsRepository.saveAll(ticketSets);
    }

    @Override
    public List<TicketSets> getTicketSets(int ticketId) {
        return ticketsRepository.findAllBySetNumber(ticketId);
    }
}
