package com.zak.fullStack.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    @NotEmpty(message = "Nom d'utilisateur obligatoire")
    private String username;

    @Column
    @NotEmpty(message = "mot de passe nécéssaire")
    private String password;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String tel;

    @Column
    private String email;

    @Column
    @NotEmpty(message = "role nécéssaire")
    private String role;

    @Column
    private String profilePicture;





}
