package com.tambola.service;

import com.tambola.mysql.models.Ticket;
import com.tambola.mysql.models.TicketSets;

import java.util.List;
import java.util.Map;

public interface TambolaService {

    public void createTambola(int n);
    public Map<String, int[][]> getTambola(int n);
}
