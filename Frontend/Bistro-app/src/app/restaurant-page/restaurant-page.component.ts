import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EMPTY, Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-restaurant-page',
  templateUrl: './restaurant-page.component.html',
  styleUrls: ['./restaurant-page.component.scss']
})
export class RestaurantPageComponent implements OnInit {

  closeModal:string | undefined;

  constructor(
    private modalService: NgbModal,
    private restaurantService: RestaurantService,
    ) { }

  triggerModal(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basi-title'}).result.then((res) => {
      this.closeModal = `Closed with ${res}`;
    }, (res) => {
      this.closeModal = `Dismissed ${this.getDismissReason(res)}`;
    });
  }

  restaurants$: Observable<Restaurant> = EMPTY;

  ngOnInit(): void {
    this.restaurants$ = this.restaurantService.getRestaurantInfo();
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

}
