package com.example.automation_for_purchasing_tickets.repositorys;

import com.example.automation_for_purchasing_tickets.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UUID, UserModel> {


}
