import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public menu = new BehaviorSubject<any>([]);
  constructor() { }
}
