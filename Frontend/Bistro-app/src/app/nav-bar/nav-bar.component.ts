import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EMPTY, Observable } from 'rxjs';
import { User } from '../user';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  closeModal: string | undefined;
  loginGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });
  user: User | null = null;

  constructor(
    private modalService: NgbModal,
    private authService: AuthService,
    private http: HttpClient,
    private readonly router: Router) { }

  triggerModal(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((res) => {
      this.closeModal = `Closed with: ${res}`;
    }, (res) => {
      this.closeModal = `Dismissed ${this.getDismissReason(res)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }

  }

  login(): void {
    if (this.loginGroup.valid) {
      const username = this.loginGroup.value.username;
      const password = this.loginGroup.value.password;
      this.modalService.dismissAll();
      this.authService.login(username, password)
        .subscribe(() => this.router.navigateByUrl('/leagues'));
    }
  }

  test(): void {
    this.http.get('http://localhost:8080/login').subscribe(data => {
      console.log(data);
      console.log("test");

    })
  }

  registerGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    email_address: new FormControl('', Validators.required),
    user_home_address: new FormControl('', Validators.required)
  })

  register(): void {
    if (this.registerGroup.valid) {
      const { username, password, email_address, user_home_address } = this.registerGroup.value;
      this.modalService.dismissAll();

      this.authService.register(username, password, email_address, user_home_address)
        .subscribe(() => {
          this.authService.login(username, password)
            .subscribe(() => this.router.navigateByUrl('/main-page'));
        });
    }
  }

  ngOnInit(): void {
    this.authService.user$
      .asObservable()
      .subscribe(user => this.user = user);
  }

}