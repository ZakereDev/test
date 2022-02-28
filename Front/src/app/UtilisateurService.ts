import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { Utilisateur } from './utilisateur';
import { Auth } from './Auth';


@Injectable({
    providedIn:'root'
})
export class UtilisateurService{
    

    
    private apiServerUrl= environment.apiBaseUrl ;
    
        //private username="zakario";
       // private password="1234"
        private username = sessionStorage.getItem('username')
        private password = sessionStorage.getItem('password')

        private headers =new HttpHeaders({Authorization:'Basic '+btoa(this.username+":"+this.password)})

        





    constructor(private http: HttpClient){}



    public getUtilisateurs():Observable<Utilisateur[]>{

        return this.http.get<Utilisateur[]>(`${this.apiServerUrl}/utilisateur/all`,{headers:this.headers})
    }

    public getUtilisateurById(id: number):Observable<Utilisateur>{
        
        
        return this.http.get<Utilisateur>(`${this.apiServerUrl}/utilisateur/${id}`,{headers:this.headers})
    }

    public addUtilisateur(utilisateur:Utilisateur):Observable<Utilisateur>{


        return this.http.post<Utilisateur>(`${this.apiServerUrl}/utilisateur/add`,utilisateur,{headers:this.headers})
    }

    public updateUtilisateur(utilisateur:Utilisateur):Observable<Utilisateur>{

        return this.http.post<Utilisateur>(`${this.apiServerUrl}/utilisateur/update`,utilisateur,{headers:this.headers})


    }
    
    public login(auth:Auth){

         this.headers =new HttpHeaders({Authorization:'Basic '+btoa(auth.username+":"+auth.password)})

         
         
        
        return this.http.post<Utilisateur>(`${this.apiServerUrl}/utilisateur/log/`,auth,{headers:this.headers})
    }



    public deleteUtilisateur(utilisateurId:number):Observable<Utilisateur>{
        return this.http.delete<Utilisateur>(`${this.apiServerUrl}/utilisateur/supprimer/${utilisateurId}`,{headers:this.headers})
    }


    

}