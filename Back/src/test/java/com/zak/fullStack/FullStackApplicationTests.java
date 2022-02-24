package com.zak.fullStack;

import com.zak.fullStack.Model.Utilisateur;
import com.zak.fullStack.repository.UtilisateurRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FullStackApplicationTests {

	@Autowired
	private UtilisateurRepository undertest;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void save() {

		Utilisateur utilisateur=new Utilisateur();
		utilisateur.setProfilePicture("none");
		utilisateur.setEmail("test@test.com");
		utilisateur.setNom("testboy");
		utilisateur.setPrenom("boyTest");
		utilisateur.setRole("ADMIN");
		utilisateur.setUsername("TEST");
		utilisateur.setPassword("TEST");

		undertest.save(utilisateur);

		boolean ex =undertest.existsByUsername("TEST");

		assertThat(ex).isTrue();

	}

	@Test
	void getListIsOk() throws Exception{
		mockMvc.perform(get("/utilisateur/all"))
				.andExpect(status().isOk());
	}

	@Test
	void delete(){
		Utilisateur utilisateur= undertest.findByUsername("TEST");
		undertest.deleteById(utilisateur.getId());

		boolean bb=undertest.existsByUsername("TEST");

		assertThat(bb).isFalse();
	}





}
