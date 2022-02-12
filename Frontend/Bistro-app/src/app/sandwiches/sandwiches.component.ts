import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-sandwiches',
  templateUrl: './sandwiches.component.html',
  styleUrls: ['./sandwiches.component.scss']
})
export class SandwichesComponent implements OnInit {
  restaurants$: Observable<Restaurant[]> = EMPTY;

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurants$ = this.restaurantService.getRestaurantsByCategory('Sandwiches');
  }

}
