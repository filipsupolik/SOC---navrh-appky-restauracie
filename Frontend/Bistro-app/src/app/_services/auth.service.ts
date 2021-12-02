import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

const AUTH_API = 'http://localhost:8080/api/auth/';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  token: string | undefined ;
  user: string | undefined;
  isLogged: boolean = false;

  constructor(private readonly http: HttpClient) { }

  getToken(): string | undefined {
    return this.token;
  }

  isLoggedIn(): boolean {
    return !!this.token;
  }

  login(username: string, password: string): Observable<any> {
    const info = btoa(`${username}:${password}`);
    const token = `Basic ${info}`;
    const options = {
      headers:new HttpHeaders({
        Authorization: token,
        'X-Request-With' : 'XMLHttpRequest'
      }),
      withCredentials: true
    };
    return this.http.get('http://localhost:8080/login', options).pipe(
      tap(() => this.token = token)
    );
  }

  register(username: string, password: string): Observable<any> {
    const user = {username, password};
    return this.http.post(`${"http://localhost:8080/api/v1/registration"}`, user);
  }

  logout() {
    this.token = null!
  }
}