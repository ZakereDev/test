import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

  constructor(private http:HttpClient) { }


  public login(username:string,password:string){
    const headers =new HttpHeaders({Authorization:'Basic '+btoa(username+":"+password)})
    
    return this.http.get("http://localhost:8800/login",{headers,responseType:'text' as 'json'})
  }

  

}
