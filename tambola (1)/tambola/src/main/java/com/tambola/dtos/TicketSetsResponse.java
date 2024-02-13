package com.tambola.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tambola.mysql.models.Ticket;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketSetsResponse {

    private  Map<String, int[][]> tickets;

    public TicketSetsResponse() {
        tickets = new HashMap<>();
    }

    public TicketSetsResponse(Map<String, int[][]> tickets) {
        this.tickets = tickets;
    }

    public Map<String, int[][]> getTickets() {
        return tickets;
    }

    public void setTickets(Map<String, int[][]> tickets) {
        this.tickets = tickets;
    }
}
