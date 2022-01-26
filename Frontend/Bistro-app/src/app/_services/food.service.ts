import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Food } from '../food.model';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private httpClient: HttpClient) { }
  
  getMenu(restaurantId: number): Observable<Food[]> {
    return this.httpClient.get<Food[]>(`http://localhost:8080/getMenu?restaurantId=${restaurantId}`);
  }
}
