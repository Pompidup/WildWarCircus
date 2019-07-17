import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Circus } from '../class/circus';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class CircusService {

  private client: HttpClient;

  constructor(http: HttpClient) {
    this.client=http;
   }

   public getAllCircus(): Observable<Circus[]> {
     return this.client.get<Circus[]>('http://localhost:8080/circus/all');
   }

   public getOne(id:number): Observable<Circus> {
     return this.client.get<Circus>('http://localhost:8080/circus/'+id);
   }

   public createCircus(circus:Circus): Observable<Circus> {
     return this.client.post('http://localhost:8080/circus', circus).pipe(
       map(
         (param_response: HttpResponse<any>) => {
           return param_response.body as Circus;
         }
       )
     );
   }

   public updateCircus(id: number, value: any): Observable<Object> {
     return this.client.put('http://localhost:8080/circus/'+id, value);
   }
}
