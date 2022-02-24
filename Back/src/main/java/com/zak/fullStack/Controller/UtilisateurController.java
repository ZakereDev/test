package com.zak.fullStack.Controller;


import com.zak.fullStack.Model.AutorisationExt;
import com.zak.fullStack.Model.Utilisateur;
import com.zak.fullStack.Service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService=utilisateurService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateur(){
        List<Utilisateur> utilisateurs = (List<Utilisateur>) utilisateurService.getUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getAllUtilisateurById(@PathVariable("id") int id){
        Utilisateur utilisateurs = utilisateurService.getUtilisateurById(id);
        return new ResponseEntity(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/login")
    public String login (){
        return
                "Authenticated";
    }
    /*
    @RequestMapping("/login")
    public boolean login (@RequestBody AutorisationExt autorisationExt){
        return
                autorisationExt.getUsername().equals("ANGULAR")&& autorisationExt.getPassword().equals("FULLSTACK");
    }*/



}
