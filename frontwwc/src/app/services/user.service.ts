import { Injectable } from '@angular/core';
import { User } from '../class/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

    public getAllUser(): Observable<User[]> {
      return this.http.get<User[]>('http://localhost:8080/user/all');
    }

    public getOneUser(username): Observable<User> {
      console.log(username);
      return this.http.get<User>('http://localhost:8080/user?username='+username)
    }

    public updateUser(id:number, value:any): Observable<Object> {
      console.log('putain d idddddddddddddddddddddddddddddddddddddddddddddddddddd',id)
      return this.http.put('http://localhost:8080/user/'+id, value);
    }
  }
