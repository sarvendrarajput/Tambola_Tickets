package com.tambola.service.strategy;

import com.tambola.mysql.models.TicketSets;

import java.util.List;

public interface TicketGenerationStartegy {

    public List<TicketSets> generateTicket(int n);
}
