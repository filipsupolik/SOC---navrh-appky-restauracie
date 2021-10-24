import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-board-moderator',
  templateUrl: './board-moderator.component.html',
  styleUrls: ['./board-moderator.component.scss']
})
export class BoardModeratorComponent implements OnInit {

  content: string | undefined;

  constructor(private userService: UserServiceService) { }

  ngOnInit(): void {
    this.userService.getModeratorBoard().subscribe (
      data => {
        this.content = data
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
