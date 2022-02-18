import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { PizzaRestaurantsComponent } from './Pizza_Restaurants/Pizza_Restaurants.component';
import { RestaurantPageComponent } from './restaurant-page/restaurant-page.component';
import { BurgerRestaurantsComponent } from './Burger-restaurants/burger-restaurants.component';
import { NoodlesRestaurantsComponent } from './noodles-restaurants/noodles-restaurants.component';
import { SandwichesComponent } from './sandwiches/sandwiches.component';
import { BreakfastComponent } from './breakfast/breakfast.component';
import { ProfileComponent } from './profile/profile.component';
import { AddingRestaurantComponent } from './adding-restaurant/adding-restaurant.component';
import { AddFoodComponent } from './add-food/add-food.component';

const routes: Routes = [
  {path: '',component: MainPageComponent},
  {path: 'login', redirectTo: '', component: LoginComponent },
  {path: 'register', component: RegisterComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'pizzarestaurants', component: PizzaRestaurantsComponent},
  {path: 'burgerrestaurants', component: BurgerRestaurantsComponent},
  {path: 'noodlerestaurants', component: NoodlesRestaurantsComponent},
  {path: 'sandwichrestaurants', component: SandwichesComponent},
  {path: 'restaurantpage/:id', component: RestaurantPageComponent},
  {path: 'breakfast', component: BreakfastComponent},
  {path: 'adding_restaurant', component: AddingRestaurantComponent},
  {path: 'adding_food', component: AddFoodComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
