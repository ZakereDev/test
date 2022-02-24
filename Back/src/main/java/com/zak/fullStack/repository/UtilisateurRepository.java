package com.zak.fullStack.repository;

import com.zak.fullStack.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    Utilisateur findByUsername(String username);

    boolean existsByUsername(String username);

}
