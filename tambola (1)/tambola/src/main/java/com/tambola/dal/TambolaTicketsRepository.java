package com.tambola.dal;

import com.tambola.mysql.models.TicketSets;

import java.util.List;

public interface TambolaTicketsRepository {
    public void insertTicketSets(List<TicketSets> ticketSets);
    public List<TicketSets> getTicketSets(int setId);
}
