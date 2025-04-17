package com.example.automation_for_purchasing_tickets.repositorys;

import com.example.automation_for_purchasing_tickets.models.BuyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface BuyRepository extends JpaRepository<BuyModel, UUID> {


}
