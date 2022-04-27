import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainPageComponent } from './main-page/main-page.component';
import { PizzaRestaurantsComponent } from './Pizza_Restaurants/Pizza_Restaurants.component';
import { RestaurantPageComponent } from './restaurant-page/restaurant-page.component';
import { NoodlesRestaurantsComponent } from './noodles-restaurants/noodles-restaurants.component';
import { SandwichesComponent } from './sandwiches/sandwiches.component';
import { BreakfastComponent } from './breakfast/breakfast.component';
import { SteakComponent } from './steak/steak.component';
import { ProfileComponent } from './profile/profile.component';
import { AddingRestaurantComponent } from './adding-restaurant/adding-restaurant.component';
import { AddFoodComponent } from './add-food/add-food.component';
import { CartComponent } from './cart/cart.component';  
import { RegionRestaurantsComponent } from './region-restaurants/region-restaurants.component';

const routes: Routes = [
  {path: '',component: MainPageComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'pizzarestaurants', component: PizzaRestaurantsComponent},
  {path: 'noodlerestaurants', component: NoodlesRestaurantsComponent},
  {path: 'sandwichrestaurants', component: SandwichesComponent},
  {path: 'restaurantpage/:id', component: RestaurantPageComponent},
  {path: 'breakfast', component: BreakfastComponent},
  {path: 'adding_restaurant', component: AddingRestaurantComponent},
  {path: 'steak', component: SteakComponent},
  {path: 'adding_food', component: AddFoodComponent},
  {path: 'shopping_cart', component: CartComponent},
  {path: 'restaurants', component: RegionRestaurantsComponent},
  {path: 'restaurants/:region', component: RegionRestaurantsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
