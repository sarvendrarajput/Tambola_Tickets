package com.tambola.mysql;

import com.tambola.mysql.models.TicketSets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MySqlTambolaTicketsRepository extends JpaRepository<TicketSets, Long> {

    public List<TicketSets> findAllBySetNumber(int setId);
}
