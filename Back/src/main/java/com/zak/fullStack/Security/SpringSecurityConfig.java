package com.zak.fullStack.Security;


import com.zak.fullStack.Model.Utilisateur;
import com.zak.fullStack.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SpringSecurityConfig(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
        this.utilisateurService = utilisateurService;
        this.passwordEncoder = passwordEncoder;
    }

    public void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                //.formLogin()
                .and()
                .cors()
                //.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        ;
    }



    public void configure(AuthenticationManagerBuilder auth)throws Exception{


        for (Utilisateur utilisateur : utilisateurService.getUtilisateurs()) {

            auth.inMemoryAuthentication()
                    .withUser(utilisateur.getUsername())
                    .password(passwordEncoder.encode(utilisateur.getPassword()))
                    .roles(utilisateur.getRole());
        }

        auth.inMemoryAuthentication()
                .withUser("ANGULAR")
                .password(passwordEncoder.encode("FULLSTACK"))
                .roles("ADMIN");

    }












}
