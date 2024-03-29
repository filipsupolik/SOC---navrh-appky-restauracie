import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Region } from '../region.enum';
import { Restaurant } from '../restaurant.model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private httpClient: HttpClient) { }

  getRestaurantById(id: number): Observable<Restaurant> {
    return this.httpClient.get<Restaurant>(`http://localhost:8080/restaurant/${id}`);
  }

  getRestaurants(): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(`http://localhost:8080/restaurant`);
  }

  getRestaurantsByCategory(category: string): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(`http://localhost:8080/getRestaurantsByCategory?category=${category}`);
  }

  getRestaurantInfo(restaurantId: number): Observable<Restaurant> {
    return this.httpClient.get<Restaurant>(`http://localhost:8080/getRestaurantInfo?restaurantId=${restaurantId}`);
  }

  getRestaurantsByRegion(region: Region): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(`http://localhost:8080/getRestaurantsByRegion?region=${region}`);
  }

  createRestaurant(restaurant: Restaurant) {
    return this.httpClient.post(`http://localhost:8080/createRestaurant`, restaurant);
  }

}
