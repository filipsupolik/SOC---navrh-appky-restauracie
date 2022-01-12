import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-all-restaurants',
  templateUrl: './Pizza_Restaurants.component.html',
  styleUrls: ['./Pizza_Restaurants.component.scss']
})
export class PizzaRestaurantsComponent implements OnInit {

  restaurants$: Observable<Restaurant[]> = EMPTY;

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurants$ = this.restaurantService.getRestaurantsByCategory('PIZZA');
  }

}
