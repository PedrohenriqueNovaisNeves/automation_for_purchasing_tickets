package com.example.automation_for_purchasing_tickets.repositorys;

import com.example.automation_for_purchasing_tickets.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByCpfUser(String cpfUser);
}
