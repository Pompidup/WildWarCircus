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

    public updateUser(id:number, value:any): Observable<Object> {
      return this.http.put('http://localhost:8080/user/'+id, value);
    }
  }
