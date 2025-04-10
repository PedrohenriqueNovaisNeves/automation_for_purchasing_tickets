package com.example.automation_for_purchasing_tickets.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
@Getter
@Setter
public class UserModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;
    private String nameUser;
    @Column(nullable = false)
    private String cpfUser;
    private String email;
    @Column(nullable = false)
    private String password;


}
