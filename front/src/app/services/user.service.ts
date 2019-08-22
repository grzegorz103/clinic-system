import { Injectable } from '@angular/core';
import { User } from "../models/user";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = 'http://localhost:8080/api/users/';

  constructor(private http: HttpClient) {
  }

  create(user: User) {
    return this.http.post<User>(this.url, user);
  }

  getToken(): string {
    return sessionStorage.getItem('token');
  }

  isAuthenticated() {
    return this.getToken() !== null && this.getToken() !== '';
  }

  hasAdminRole() {
    return localStorage.getItem('adminRole') !== null && localStorage.getItem('adminRole') === 'true';
  }

  fetchAdminRole() {
    this.http.get<boolean>(this.url).subscribe(res => localStorage.setItem('adminRole', String(res)));
  }

  getUsername() {
    return localStorage.getItem('username');
  }

  isLoginCorrect(username: string, password: string) {
    return this.http.post<Observable<boolean>>('/api/users/login', {
      username: username,
      password: password,
      passwordConfirm: password
    });
  }

}
