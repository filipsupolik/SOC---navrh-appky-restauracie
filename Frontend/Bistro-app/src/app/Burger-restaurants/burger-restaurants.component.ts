import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-burger-restaurants',
  templateUrl: './burger-restaurants.component.html',
  styleUrls: ['./burger-restaurants.component.scss']
})
export class BurgerRestaurantsComponent implements OnInit {

  restaurants$: Observable<Restaurant[]> = EMPTY;

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurants$ = this.restaurantService.getRestaurantsByCategory('Burger');
  }

}
