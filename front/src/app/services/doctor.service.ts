import {Injectable} from '@angular/core';
import {Doctor} from "../models/doctor";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  url = 'http://localhost:8080/api/doctors/';

  constructor(private http: HttpClient) {
  }

  findAll() {
    return this.http.get<Doctor[]>(this.url);
  }
}
