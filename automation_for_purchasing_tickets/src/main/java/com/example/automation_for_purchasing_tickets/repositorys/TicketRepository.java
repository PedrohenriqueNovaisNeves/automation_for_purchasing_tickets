package com.example.automation_for_purchasing_tickets.repositorys;

import com.example.automation_for_purchasing_tickets.models.TicketsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<TicketsModel, UUID> {

}
