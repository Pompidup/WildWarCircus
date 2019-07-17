import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Crasse } from '../class/crasse';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CrasseService {

  constructor(private http: HttpClient) { }

    public getAllCrasse(): Observable<Crasse[]> {
      return this.http.get<Crasse[]>('http://localhost:8080/crasse/all');
    }

  }
