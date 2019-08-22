import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  url = 'http://localhost:8080/api/doctors/';

  constructor() { }
}
