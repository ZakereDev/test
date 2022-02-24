package com.zak.fullStack.Service;

import com.zak.fullStack.Model.Utilisateur;
import com.zak.fullStack.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    public UtilisateurRepository utilisateurRepository;

    public Utilisateur addUtiliasteur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);

    }

    public Iterable<Utilisateur> getUtilisateurs (){
        return utilisateurRepository.findAll();

    }

    public Utilisateur getUtilisateurById(int id){
        return utilisateurRepository.findById(id).get();
    }

    public Utilisateur setRoleById(int id , String role){
        Utilisateur utilisateur =utilisateurRepository.findById(id).get();
        utilisateur.setRole(role);
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    public void deleteUtilisateurById(int id){
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur changeNom(String nom ,int id){
        Utilisateur utilisateur = utilisateurRepository.findById(id).get();
        utilisateur.setNom(nom);
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    public Utilisateur changePrenom(String prenom ,int id){
        Utilisateur utilisateur = utilisateurRepository.findById(id).get();
        utilisateur.setNom(prenom);
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    public Utilisateur changeEmail(String email, int id){
        Utilisateur utilisateur=utilisateurRepository.findById(id).get();
        utilisateur.setEmail(email);
        utilisateurRepository.save(utilisateur);
        return utilisateur;

    }

    public Utilisateur changeProfilePicture(String profilePicture, int id){
        Utilisateur utilisateur=utilisateurRepository.findById(id).get();
        utilisateur.setProfilePicture(profilePicture);
        utilisateurRepository.save(utilisateur);
        return utilisateur;

    }





}
