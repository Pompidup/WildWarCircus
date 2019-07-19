import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pub } from '../class/pub';

@Injectable({
  providedIn: 'root'
})
export class PubService {

  constructor(private http: HttpClient) { }

    public getAllPub(): Observable<Pub[]> {
      return this.http.get<Pub[]>('http://localhost:8080/pub/all');
    }

  }
