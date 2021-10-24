import { Injectable } from '@angular/core';
import { HTTP_INTERCEPTORS, HttpEvent } from '@angular/common/http';
import {
  HttpRequest,
  HttpHandler,
  HttpErrorResponse,
  HttpInterceptor
} from '@angular/common/http';
import { tap } from 'rxjs/operators'
import { Observable } from 'rxjs';
import { TokenStorageService } from './Service/token-storage.service';
import { Router } from '@angular/router';

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private token: TokenStorageService, private router: Router) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = request;
    const loginPath = '/login';
    const token = this.token.getToken();
    if (token != null) {
      authReq = request.clone({ headers: request.headers.set(TOKEN_HEADER_KEY, 'Bearer' + token) });
    }
    return next.handle(authReq).pipe( tap(() => {},
    (err: any) => {
      if (err.status !== 401 || window.location.pathname === loginPath) {
        return;
      }
      this.token.signOut();
      window.location.href = loginPath;

    }
    ));
  }
}

export const authInterceptorProvider = [
  { provider: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
];
