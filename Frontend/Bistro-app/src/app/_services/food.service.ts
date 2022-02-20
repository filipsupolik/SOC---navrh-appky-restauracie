import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Food } from '../food.model';
import { CATEGORY } from '../category'; 

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private httpClient: HttpClient) { }
  
  getMenu(restaurantId: number): Observable<Food[]> {
    return this.httpClient.get<Food[]>(`http://localhost:8080/getMenu?restaurantId=${restaurantId}`);
  }

  getCategoryById(categoryId: number): Observable<CATEGORY[]> {
    return this.httpClient.get<CATEGORY[]>(`http://localhost:8080/getCategoryById?categoryId=${categoryId}`);
  }

  getAllCategories(): Observable<CATEGORY[]> {
    return this.httpClient.get<CATEGORY[]>(`http://localhost:8080/getAllCategories`);
  }

  addFood(food: Food) {
    return this.httpClient.post(`http://localhost:8080/addFood`, food);
  }
}
