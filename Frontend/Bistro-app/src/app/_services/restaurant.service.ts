import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../restaurant.model';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private httpClient: HttpClient) { }

  getRestaurantById(id: number): Observable<Restaurant> {
    return this.httpClient.get<Restaurant>(`http://localhost:8080/restaurant/${id}`);
  }

  getRestaurantsByCategory(category: string): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(`http://localhost:8080/getRestaurantsByCategory?category=${category}`);
  }

  getRestaurantInfo(): Observable<Restaurant> {
    return this.httpClient.get<Restaurant>(`http://localhost:8080/getRestaurantInfo?restaurantId`);
  }

}
