import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  url = 'http://localhost:8080/api/visits/';

  constructor() { }
}
