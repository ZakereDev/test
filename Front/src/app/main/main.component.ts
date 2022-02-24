import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RestApiService } from '../rest-api.service';
import { Utilisateur } from '../utilisateur';
import { UtilisateurService } from '../UtilisateurService';



@Component({
  selector: 'app-root',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  title = 'fullstack';

  public utilisateurs!:Utilisateur[];
  public editUtilisateur!:Utilisateur;
  public deleteUtilisateur!:Utilisateur;

  constructor(private utilisateurService:UtilisateurService,private service:RestApiService){}

  ngOnInit(){
    this.getUtilisateurs();
  }

  doLogin(){
    let resp=this.service.login("ANGULAR","FULLSTACK");
    resp.subscribe((data)=>{console.log(data)})
  }


  public getUtilisateurs():void{
    this.utilisateurService.getUtilisateurs().subscribe(
      (response:Utilisateur[])=>{
        this.utilisateurs=response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
        alert("TEST")
        
      }
      )
    
  }



  public searchUtilisateurs(key: String): void{
    const results :Utilisateur[] =[];
    for(const utilisateur of this.utilisateurs){
      if(utilisateur.nom.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) !== -1
      || utilisateur.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || utilisateur.tel.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || utilisateur.role.toLowerCase().indexOf(key.toLowerCase()) !==-1
      || utilisateur.prenom.toLowerCase().indexOf(key.toLowerCase()) !==-1   
      || utilisateur.username.toLowerCase().indexOf(key.toLowerCase()) !==-1){
        results.push(utilisateur)
      }
    }
    this.utilisateurs=results;
    if (results.length===0||!key) {
      this.getUtilisateurs();
    }
    
  }

  public onOpenModal(utilisateur:Utilisateur|null,mode:String):void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type ='button';
    button.style.display='none'; 
    button.setAttribute('data-toggle','modal');
    if(mode ==='add'){ button.setAttribute('data-target' , '#addEmployeeModal')}
    if(mode ==='edit' && utilisateur){ 
      this.editUtilisateur=utilisateur
      button.setAttribute('data-target' , '#editEmployeeModal')}
    if(mode ==='delete'&& utilisateur){
      this.deleteUtilisateur=utilisateur;
      button.setAttribute('data-target' , '#deleteEmployeeModal')}

    container?.appendChild(button);
    button.click();

  }

  onAddModal(addForm:NgForm):void{
    this.utilisateurService.addUtilisateur(addForm.value).subscribe(
      (response : Utilisateur)=>{
        console.log(response)
        this.getUtilisateurs();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }


  onUpdateModal(utilisateur:Utilisateur):void{
    this.utilisateurService.updateUtilisateur(utilisateur).subscribe(
      (response : Utilisateur)=>{
        console.log(response)
        this.getUtilisateurs();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }


  onDeleteModal(utilisateurId:number|undefined):void{
    if (utilisateurId){
    this.utilisateurService.deleteUtilisateur(utilisateurId).subscribe(
      (response : Utilisateur)=>{
        console.log(response)
        this.getUtilisateurs();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
    
  }

}
}