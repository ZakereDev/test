package com.zak.fullStack.Controller;


import com.zak.fullStack.Model.AutorisationExt;
import com.zak.fullStack.Model.Response;
import com.zak.fullStack.Model.Utilisateur;
import com.zak.fullStack.Service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/utilisateur")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @CrossOrigin(origins = "http://localhost:4200")  //OK
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


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Response> deleteUtilisateur(@PathVariable("id") int id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("supprimé",utilisateurService.deleteUtilisateurById(id)))
                        .message("Server supprimé")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );

    }

    @PostMapping("/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Utilisateur> saveServers(@RequestBody Utilisateur utilisateur) throws IOException {
        utilisateurService.create(utilisateur);
        return new ResponseEntity<>(utilisateur,HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/update")
    public String post(){
        return "POST REQUIS";
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Utilisateur> addServers(@RequestBody Utilisateur utilisateur) throws IOException {
        utilisateurService.create(utilisateur);
        return new ResponseEntity<>(utilisateur,HttpStatus.OK);
    }


    @PostMapping("/log")
    public ResponseEntity<Utilisateur> login(@RequestBody AutorisationExt auth) throws IOException{

        Utilisateur utilisateur = utilisateurService.getUtilisateurByUsername(auth.getUsername());
        System.out.println(utilisateur.toString()+" a :"+auth.toString());
        System.out.println("utilisateur "+utilisateur.getUsername()+"  "+auth.getUsername()+"  Password  :"+utilisateur.getPassword()+" "+auth.getPassword());

        if (auth.getPassword().equals(utilisateur.getPassword())){
            System.out.println("AUTHENTIFICATION R2USSIE");
            return new ResponseEntity(utilisateur, HttpStatus.OK);
        }
        else System.out.println("MAUAVISE AUTHENTIFICATION"); return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


}
