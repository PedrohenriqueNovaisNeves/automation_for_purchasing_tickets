package com.example.automation_for_purchasing_tickets.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
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


    public UUID getIdUser() {
        return idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getCpfUser() {
        return cpfUser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setCpfUser(String cpfUser) {
        this.cpfUser = cpfUser;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
