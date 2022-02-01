import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-breakfast',
  templateUrl: './breakfast.component.html',
  styleUrls: ['./breakfast.component.scss']
})
export class BreakfastComponent implements OnInit {

  restaurants$: Observable <Restaurant[]> = EMPTY;

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurants$ = this.restaurantService.getRestaurantsByCategory('Breakfast');
  }

}
