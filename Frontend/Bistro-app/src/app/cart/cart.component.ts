import { Component, OnInit } from '@angular/core';
import { Food } from '../food.model';
import { CartEntry, CartService } from '../_services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  items: CartEntry[];

  constructor(private cartService: CartService) {
    this.items = cartService.getItems();
  }

  ngOnInit(): void {
  }

  remove(entry: CartEntry): void {
    this.cartService.removeSingleItem(entry.food);
    this.items = this.cartService.getItems();
  }

}
