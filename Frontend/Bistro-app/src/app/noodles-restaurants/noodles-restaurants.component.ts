import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-noodles-restaurants',
  templateUrl: './noodles-restaurants.component.html',
  styleUrls: ['./noodles-restaurants.component.scss']
})
export class NoodlesRestaurantsComponent implements OnInit {

  restaurants$: Observable<Restaurant[]> = EMPTY;

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurants$ = this.restaurantService.getRestaurantsByCategory('Noodles')

  }

}
