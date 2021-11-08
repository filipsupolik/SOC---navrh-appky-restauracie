import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  })
  
  constructor(private authService: AuthService, private readonly router: Router) {}

  register(): void {
    if (this.registerGroup.valid) {
      const username = this.registerGroup.value.username;
      const password = this.registerGroup.value.username;
      this.authService.register(username, password)
        .subscribe(() => {
          this.authService.login(username, password)
            .subscribe(() => this.router.navigateByUrl('/main-page'));
        });
    }
  }

  ngOnInit(): void {
    
  } 
}