import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from '../order.module';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

  addOrder(order: Order) {
    return this.httpClient.post(`http://localhost:8080/addOrder`, order);
  }
}
