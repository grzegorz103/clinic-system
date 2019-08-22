import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  url = 'http://localhost:8080/api/patients/';

  constructor() { }
}
