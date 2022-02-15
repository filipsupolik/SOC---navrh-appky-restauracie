import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { User } from '../user';
import { AuthService } from '../_services/auth.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor(
    public auth: AuthService,
    private userService: UserService) { }

    user$: Observable<User> = EMPTY;

  ngOnInit(): void {
    this.user$ = this.userService.getCurrentUser();
  }

}
