import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from '../user';

const AUTH_API = 'http://localhost:8080/api/auth/';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  token: string | undefined ;
  isLogged: boolean = false;
  user$ = new BehaviorSubject<User | null>(null);

  constructor(private readonly http: HttpClient) { }

  getToken(): string | undefined {
    return this.token;
  }

  isLoggedIn(): boolean {
    return !!this.token;
  }

  login(username: string, password: string): Observable<any> {
    console.log("register");
    
    const info = btoa(`${username}:${password}`);
    const token = `Basic ${info}`;
    const options = {
      headers:new HttpHeaders({
        Authorization: token,
        'X-Request-With' : 'XMLHttpRequest'
      }),
    };
    return this.http.get<User>('http://localhost:8080/login', options).pipe(
      tap(() => this.token = token),
      tap(user => this.user$.next(user)),
    );
  }

  register(username: string, password: string, email_address: string, user_home_address: string): Observable<any> {
    const user = {username, password, email_address, user_home_address};
    return this.http.post(`${"http://localhost:8080/register"}`, user);
  }

  logout() {
    this.token = null!
  }
}