import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Auth } from '../Auth';
import { RestApiService } from '../rest-api.service';
import { UtilisateurService } from '../UtilisateurService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  username!:string;
  password!:string;
  message!:string;
  auth!:Auth;
  

  constructor(private service:UtilisateurService,private router:Router) { }

  ngOnInit(): void {
  }

  onLogin(ngForm:NgForm){

    this.auth=ngForm.value

    sessionStorage.setItem('username',this.auth.username);
    sessionStorage.setItem('password',this.auth.password);


    let resp=this.service.login(this.auth);


    
    resp.subscribe(data=>
      {console.log(data)
      if(data.username==this.auth.username){this.router.navigate([`main`])}else alert("Mauvais nom d'utilisateur ou mots de passe")
            })

     
        
    

    

    
    
  }
  
  

}
