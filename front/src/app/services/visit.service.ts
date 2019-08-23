import { Injectable } from '@angular/core';
import { Visit } from "../models/visit";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  url = 'http://localhost:8080/api/visits/';

  constructor(private http: HttpClient) { }

  create(visit: Visit) {
    return this.http.post<Visit>(this.url, visit);
  }

  findUsers() {
    return this.http.get<Visit[]>(this.url + 'my');
  }

  update(visit: Visit) {
    return this.http.put<Visit>(this.url, visit);
  }

  findById(id: number) {
    return this.http.get<Visit>(this.url + 'one/' + id);
  }

  remove(id: number){
    return this.http.delete<Visit>(this.url + id);
  }
}
