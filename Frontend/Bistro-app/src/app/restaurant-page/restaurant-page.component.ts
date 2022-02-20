import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EMPTY, Observable } from 'rxjs';
import { CATEGORY } from '../category';
import { Food } from '../food.model';
import { Order } from '../order.module';
import { OrderComponent } from '../order/order.component';
import { Restaurant } from '../restaurant.model';
import { FoodService } from '../_services/food.service';
import { OrderService } from '../_services/order.service';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-restaurant-page',
  templateUrl: './restaurant-page.component.html',
  styleUrls: ['./restaurant-page.component.scss']
})
export class RestaurantPageComponent implements OnInit {

  constructor(
    private modalService: NgbModal,
    private restaurantService: RestaurantService,
    private foodService: FoodService,
    private orderService: OrderService,
    private route: ActivatedRoute,
    public _snackBar: MatSnackBar
    ) { }

  durationInSeconds = 5;
  closeModal:string | undefined;
  restaurants$: Observable<Restaurant> = EMPTY;
  menu$: Observable<Food[]> = EMPTY;

  ngOnInit(): void {
    const id = +(this.route.snapshot.paramMap.get('id') ?? 1);
    this.restaurants$ = this.restaurantService.getRestaurantInfo(id);
    this.menu$ = this.foodService.getMenu(id);
  }
  
  triggerModal(content: any) {
      this.modalService.open(content, {ariaLabelledBy: 'modal-basi-title'}).result.then((res) => {
        this.closeModal = `Closed with ${res}`;
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
      return  `with: ${reason}`;
    }
  }

  openSnackBar() {
    this._snackBar.openFromComponent(OrderComponent, {
      duration: this.durationInSeconds * 1000,
    });
  }

}
