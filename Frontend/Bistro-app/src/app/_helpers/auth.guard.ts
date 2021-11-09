import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    constructor(
        private readonly authService: AuthService,
        private readonly router: Router,
        ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean> | boolean {
        if (!this.authService.isLoggedIn()) {
            return this.router.navigateByUrl('/login').then(() => false);
        }
        return true;
    }
  }
  