import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stand } from '../class/stand';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StandService {


  constructor(private http: HttpClient) { }

    public getAllStand(): Observable<Stand[]> {
      return this.http.get<Stand[]>('http://localhost:8080/stand/all');
    }

    public updateStand(id:number, value:any): Observable<Object> {
      return this.http.put('http://localhost:8080/stand/'+id, value);
    }

  }
