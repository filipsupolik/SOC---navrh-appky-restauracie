import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { Region } from '../region.enum';
import { Restaurant } from '../restaurant.model';
import { RestaurantService } from '../_services/restaurant.service';

const REGION_KEY_TO_REGION: { [key: string]: Region | undefined } = {
  'Žilina': Region.ZILINSKY,
  'Bratislava': Region.BRATISLAVSKY,
};

@Component({
  selector: 'app-region-restaurants',
  templateUrl: './region-restaurants.component.html',
  styleUrls: ['./region-restaurants.component.scss']
})
export class RegionRestaurantsComponent implements OnInit, OnDestroy {

  fetchedRestaurants: Restaurant[] = [];
  filteredRestaurants: Restaurant[] = [];
  subscription?: Subscription;

  constructor(
    private route: ActivatedRoute,
    private restaurantService: RestaurantService,
  ) { }

  ngOnInit(): void {
    const regionKey: string | null = this.route.snapshot.paramMap.get('region');
    const region: Region | null = this.getRegion(regionKey);

    const restaurantSource: Observable<Restaurant[]> = region
      ? this.restaurantService.getRestaurantsByRegion(region) 
      : this.restaurantService.getRestaurants();

    this.subscription = restaurantSource.subscribe(restaurants => {
      this.fetchedRestaurants = restaurants;
      this.applyFilter();
    });
  }

  applyFilter(): void {
    this.filteredRestaurants = this.fetchedRestaurants;
  }

  getRegion(regionKey: string | null): Region | null {
    if (regionKey) {
      const region = REGION_KEY_TO_REGION[regionKey];

      if (region) {
        return region;
      }
    }

    return null;
  }

  ngOnDestroy(): void {
    this.subscription?.unsubscribe();
  }

}
