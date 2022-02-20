import { Component, OnInit } from '@angular/core';
import { EMPTY, Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

@Component({
  selector: 'app-steak',
  templateUrl: './steak.component.html',
  styleUrls: ['./steak.component.scss']
})
export class SteakComponent implements OnInit {

restaurants$: Observable<Restaurant[]> = EMPTY;

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurants$ = this.restaurantService.getRestaurantsByCategory('Steak');
  }

}
