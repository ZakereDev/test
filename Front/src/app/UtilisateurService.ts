import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { Utilisateur } from './utilisateur';


@Injectable({
    providedIn:'root'
})
export class UtilisateurService{
    private apiServerUrl= environment.apiBaseUrl ;

    constructor(private http: HttpClient){}

    public getUtilisateurs():Observable<Utilisateur[]>{
        const headers =new HttpHeaders({Authorization:'Basic'+btoa("zakario"+":"+"1234")})
        return this.http.get<Utilisateur[]>(`${this.apiServerUrl}/utilisateur/all`,{headers:headers})
    }

    public addUtilisateur(utilisateur:Utilisateur):Observable<Utilisateur>{
        return this.http.post<Utilisateur>(`${this.apiServerUrl}/Utilisateur/add`,utilisateur)
    }

    public updateUtilisateur(utilisateur:Utilisateur):Observable<Utilisateur>{
        return this.http.post<Utilisateur>(`${this.apiServerUrl}/Utilisateur/update`,utilisateur)
    }

    public deleteUtilisateur(utilisateurId:number):Observable<Utilisateur>{
        return this.http.delete<Utilisateur>(`${this.apiServerUrl}/Utilisateur/delete/${utilisateurId}`)
    }


    public login(username:string,password:string){
        return this.http.post(`${this.apiServerUrl}/login`,{username,password})
    }



}