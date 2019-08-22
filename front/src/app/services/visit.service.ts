import { Injectable } from '@angular/core';
import {Visit} from "../models/visit";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  url = 'http://localhost:8080/api/visits/';

  constructor(private http: HttpClient) { }

  create(visit: Visit){
    return this.http.post<Visit>(this.url, visit);
  }
}
