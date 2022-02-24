package com.zak.fullStack;

import com.zak.fullStack.Model.Utilisateur;
import com.zak.fullStack.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullStackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FullStackApplication.class, args);
	}


	@Autowired
	private UtilisateurService utilisateurService;


	@Override
	public void run(String... args) throws Exception {

		/*
		Utilisateur zak=new Utilisateur();
		zak.setEmail("gapalou@hotmail.fr");
		zak.setNom("NSANGOU");
		zak.setPrenom("ZAK");
		zak.setTel("0666499788");
		zak.setPassword("1234");
		zak.setUsername("zakario");

		utilisateurService.addUtiliasteur(zak);

		 */

		//utilisateurService.setRoleById(1,"ADMIN");
		//utilisateurService.setRoleById(2,"USER");

		//utilisateurService.getUtilisateurs().forEach(
		//		utilisateur -> System.out.println(utilisateur.getUsername()+"  "+utilisateur.getRole())
		//);

		utilisateurService.changeProfilePicture("https://i.pinimg.com/736x/e4/f2/a8/e4f2a88aeac0f4ece64e174fa35dbe6b.jpg",1);
		utilisateurService.changeProfilePicture("https://i1.sndcdn.com/avatars-O6N3M1oW1PAw5UVz-RucxOQ-t500x500.jpg",2);




	}
}
