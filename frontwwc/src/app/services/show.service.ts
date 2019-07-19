import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Show } from '../class/show';

@Injectable({
  providedIn: 'root'
})
export class ShowService {

  constructor(private http: HttpClient) { }

    public getAllShow(): Observable<Show[]> {
      return this.http.get<Show[]>('http://localhost:8080/show/all');
    }

    public updateShow(id:number, value:any): Observable<Object> {
      return this.http.put('http://localhost:8080/show/'+id, value);
    }

  }
