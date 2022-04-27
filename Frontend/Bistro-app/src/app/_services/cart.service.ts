import { Injectable } from '@angular/core';
import { Food } from '../food.model';

export interface CartEntry {
  food: Food;
  count: number;
}

@Injectable({
  providedIn: 'root'
})
export class CartService {

  items: CartEntry[] = [];

  addItem(food: Food): void {
    const existing = this.items.find(e => e.food.id == food.id);

    if (existing) {
      existing.count++;
    } else {
      this.items.push({ food, count: 1 });
    }
  }

  getItems(): CartEntry[] {
    return this.items;
  }

  clearCart(): CartEntry[] {
    return this.items = [];
  }

  removeSingleItem(food: Food): void {
    const entryIndex = this.items.findIndex(e => e.food.id == food.id);

    if (entryIndex !== -1) {
      const entry = this.items[entryIndex];
      entry.count--;

      if (entry.count <= 0) {
        this.items.splice(entryIndex, 1);
      }
    }
  }

}