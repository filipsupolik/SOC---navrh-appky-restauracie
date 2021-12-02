import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  showFiller = false;

  loginGroup = new FormGroup ({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  })

  constructor(
    private authService: AuthService,
    private http: HttpClient,
    private router: Router,) { }

    login(): void {
      if (this.loginGroup.valid) {
        const username = this.loginGroup.value.username;
        const password = this.loginGroup.value.password;
        this.authService.login(username, password)
          .subscribe(() => this.router.navigateByUrl('/leagues'));
      }
    }

  ngOnInit(): void {
  }

  reloadPage(): void {
    window.location.reload();
  }

  test(): void {
    this.http.get('http://localhost:8080/getRestaurantsByCategory?category=Burger').subscribe(data => console.log(data))
  }
}  